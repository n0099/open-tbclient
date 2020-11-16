package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
import com.baidu.webkit.internal.ETAG;
import java.net.URISyntaxException;
/* loaded from: classes25.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView agr;
    private TextView gma;
    private TbImageView iqx;
    private com.baidu.adp.lib.b.b jWq;
    private TextView kao;
    private ImageView mArrow;
    private Context mContext;
    private View mDivider;
    private int mPosition;
    private TextView mTitle;

    public SingleImageTextView(Context context) {
        this(context, null);
    }

    public SingleImageTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleImageTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jWq = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.agr = (TextView) findViewById(R.id.single_abstract);
        this.iqx = (TbImageView) findViewById(R.id.single_content_pic);
        this.iqx.setAutoChangeStyle(false);
        this.iqx.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.iqx.setConrers(15);
        this.kao = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.mDivider = findViewById(R.id.single_divider);
        this.gma = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.jWq != null) {
                    SingleImageTextView.this.jWq.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0766a c0766a, View view, final int i) {
        if (c0766a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0766a.title)) {
                str = c0766a.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(c0766a.text)) {
                str2 = c0766a.text;
            }
            this.agr.setText(str2);
            if (!TextUtils.isEmpty(c0766a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        int i2;
                        if (c0766a != null && c0766a.url != null && c0766a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(c0766a.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        bf.bqF().b(tbPageContext, new String[]{c0766a.url});
                        if (c0766a.url != null && c0766a.url.contains("ForumGradePage")) {
                            ar w = new ar("c13783").w("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse = Uri.parse(c0766a.url);
                                String queryParameter = parse.getQueryParameter("forum_id");
                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                w.dR("fid", queryParameter);
                                w.dR("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(w);
                        }
                        if (c0766a.url != null && c0766a.url.contains("weeklygodview")) {
                            TiebaStatic.log(new ar("c13691").w("uid", TbadkCoreApplication.getCurrentAccountId()).ak("obj_source", 1));
                        }
                        if (c0766a.url != null && c0766a.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new ar("c13665").w("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", c0766a.fid);
                            com.baidu.tieba.im.data.d MO = com.baidu.tieba.im.util.e.MO(c0766a.jYo);
                            if (MO != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", MO.kcG, "task_id", MO.taskId, "loc", "0");
                                if ((c0766a.userType == 1 || c0766a.userType == 3) && !"0".equals(MO.taskId)) {
                                    com.baidu.tieba.im.b.a.cUP().MI(MO.taskId);
                                }
                            }
                            ar arVar = new ar("official_message_open_detail");
                            arVar.w("msg_id", c0766a.kna / 100);
                            arVar.dR("official_id", c0766a.knb);
                            arVar.ak("official_type", c0766a.knc);
                            arVar.w("operate_time", System.currentTimeMillis() / 1000);
                            arVar.w("task_id", c0766a.taskId);
                            arVar.dR("obj_params1", c0766a.url);
                            TiebaStatic.log(arVar);
                        }
                        ar arVar2 = new ar("c13784");
                        arVar2.w(Constants.EXTRA_SERVICE, c0766a.serviceId);
                        arVar2.w("task_id", c0766a.taskId);
                        arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.dR("fid", c0766a.fid);
                        if (!TextUtils.isEmpty(c0766a.title)) {
                            if (!TextUtils.isEmpty(c0766a.url)) {
                                String str3 = null;
                                String[] split = c0766a.url.split("tid=");
                                if (split.length > 1) {
                                    int indexOf = split[1].indexOf(ETAG.ITEM_SEPARATOR);
                                    if (indexOf != -1) {
                                        str3 = split[1].substring(0, indexOf);
                                    } else {
                                        str3 = split[1].substring(0);
                                    }
                                }
                                arVar2.dR("tid", str3);
                            }
                            if (c0766a.title.contains("互动量")) {
                                arVar2.ak("obj_source", 2);
                                arVar2.ak("obj_type", 9);
                            } else if (c0766a.title.contains("被加精")) {
                                arVar2.ak("obj_source", 1);
                                arVar2.ak("obj_type", 9);
                            } else if (c0766a.title.contains("热贴榜")) {
                                arVar2.ak("obj_type", 8);
                            } else if (c0766a.userType == 4) {
                                arVar2.ak("obj_type", 10);
                            } else if (c0766a.userType == 3) {
                                arVar2.ak("obj_type", 5);
                            }
                        }
                        if (c0766a.knb != null && c0766a.knb.equals("4754917018")) {
                            arVar2.delete("obj_type");
                            arVar2.ak("obj_type", 9);
                            if (c0766a.url != null) {
                                if (c0766a.url.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (c0766a.url.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (c0766a.url.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = c0766a.url.contains("type=attention-common") ? 5 : -1;
                                }
                                if (i2 != -1) {
                                    arVar2.delete("obj_source");
                                    arVar2.ak("obj_source", i2);
                                }
                            }
                        }
                        TiebaStatic.log(arVar2);
                    }
                });
            }
            if (!TextUtils.isEmpty(c0766a.src)) {
                this.iqx.setTag(c0766a.src);
                this.iqx.startLoad(c0766a.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.agr.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.agr.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.agr.setText("");
        this.iqx.setBackgroundDrawable(null);
        this.iqx.setImageDrawable(null);
        this.gma.setText("");
        this.gma.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jWq = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void rC(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.iqx.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, 1, skinType);
        ap.setViewTextColor(this.agr, R.color.CAM_X0109, 1, skinType);
        ap.setViewTextColor(this.kao, R.color.CAM_X0107, 1, skinType);
        SvgManager.bqB().a(this.mArrow, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.gma, R.color.common_color_10067, 1, skinType);
        ap.setBackgroundResource(this.mDivider, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gma.setVisibility(8);
            this.gma.setText("");
            return;
        }
        this.gma.setVisibility(0);
        this.gma.setText(str);
    }
}
