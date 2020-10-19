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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
import com.baidu.webkit.internal.ETAG;
import java.net.URISyntaxException;
/* loaded from: classes26.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView agl;
    private TextView fWB;
    private TbImageView hXk;
    private com.baidu.adp.lib.b.b jDk;
    private TextView jHj;
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
        this.jDk = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.agl = (TextView) findViewById(R.id.single_abstract);
        this.hXk = (TbImageView) findViewById(R.id.single_content_pic);
        this.hXk.setAutoChangeStyle(false);
        this.hXk.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.hXk.setConrers(15);
        this.jHj = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.mDivider = findViewById(R.id.single_divider);
        this.fWB = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.jDk != null) {
                    SingleImageTextView.this.jDk.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0734a c0734a, View view, final int i) {
        if (c0734a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0734a.title)) {
                str = c0734a.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(c0734a.text)) {
                str2 = c0734a.text;
            }
            this.agl.setText(str2);
            if (!TextUtils.isEmpty(c0734a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        int i2;
                        if (c0734a != null && c0734a.url != null && c0734a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(c0734a.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        be.bmY().b(tbPageContext, new String[]{c0734a.url});
                        if (c0734a.url != null && c0734a.url.contains("ForumGradePage")) {
                            aq u = new aq("c13783").u("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse = Uri.parse(c0734a.url);
                                String queryParameter = parse.getQueryParameter("forum_id");
                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                u.dK("fid", queryParameter);
                                u.dK("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(u);
                        }
                        if (c0734a.url != null && c0734a.url.contains("weeklygodview")) {
                            TiebaStatic.log(new aq("c13691").u("uid", TbadkCoreApplication.getCurrentAccountId()).aj("obj_source", 1));
                        }
                        if (c0734a.url != null && c0734a.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new aq("c13665").u("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", c0734a.fid);
                            com.baidu.tieba.im.data.d My = com.baidu.tieba.im.util.e.My(c0734a.jFi);
                            if (My != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", My.jJA, "task_id", My.taskId, "loc", "0");
                                if ((c0734a.userType == 1 || c0734a.userType == 3) && !"0".equals(My.taskId)) {
                                    com.baidu.tieba.im.b.a.cPB().Ms(My.taskId);
                                }
                            }
                            aq aqVar = new aq("official_message_open_detail");
                            aqVar.u("msg_id", c0734a.jTT / 100);
                            aqVar.dK("official_id", c0734a.jTU);
                            aqVar.aj("official_type", c0734a.jTV);
                            aqVar.u("operate_time", System.currentTimeMillis() / 1000);
                            aqVar.u("task_id", c0734a.taskId);
                            aqVar.dK("obj_params1", c0734a.url);
                            TiebaStatic.log(aqVar);
                        }
                        aq aqVar2 = new aq("c13784");
                        aqVar2.u(Constants.EXTRA_SERVICE, c0734a.serviceId);
                        aqVar2.u("task_id", c0734a.taskId);
                        aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.dK("fid", c0734a.fid);
                        if (!TextUtils.isEmpty(c0734a.title)) {
                            if (!TextUtils.isEmpty(c0734a.url)) {
                                String str3 = null;
                                String[] split = c0734a.url.split("tid=");
                                if (split.length > 1) {
                                    int indexOf = split[1].indexOf(ETAG.ITEM_SEPARATOR);
                                    if (indexOf != -1) {
                                        str3 = split[1].substring(0, indexOf);
                                    } else {
                                        str3 = split[1].substring(0);
                                    }
                                }
                                aqVar2.dK("tid", str3);
                            }
                            if (c0734a.title.contains("互动量")) {
                                aqVar2.aj("obj_source", 2);
                                aqVar2.aj("obj_type", 9);
                            } else if (c0734a.title.contains("被加精")) {
                                aqVar2.aj("obj_source", 1);
                                aqVar2.aj("obj_type", 9);
                            } else if (c0734a.title.contains("热贴榜")) {
                                aqVar2.aj("obj_type", 8);
                            } else if (c0734a.userType == 4) {
                                aqVar2.aj("obj_type", 10);
                            } else if (c0734a.userType == 3) {
                                aqVar2.aj("obj_type", 5);
                            }
                        }
                        if (c0734a.jTU != null && c0734a.jTU.equals("4754917018")) {
                            aqVar2.delete("obj_type");
                            aqVar2.aj("obj_type", 9);
                            if (c0734a.url != null) {
                                if (c0734a.url.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (c0734a.url.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (c0734a.url.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = c0734a.url.contains("type=attention-common") ? 5 : -1;
                                }
                                if (i2 != -1) {
                                    aqVar2.delete("obj_source");
                                    aqVar2.aj("obj_source", i2);
                                }
                            }
                        }
                        TiebaStatic.log(aqVar2);
                    }
                });
            }
            if (!TextUtils.isEmpty(c0734a.src)) {
                this.hXk.setTag(c0734a.src);
                this.hXk.startLoad(c0734a.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.agl.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.agl.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.agl.setText("");
        this.hXk.setBackgroundDrawable(null);
        this.hXk.setImageDrawable(null);
        this.fWB.setText("");
        this.fWB.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jDk = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void qY(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.hXk.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b, 1, skinType);
        ap.setViewTextColor(this.agl, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.jHj, R.color.cp_cont_j, 1, skinType);
        SvgManager.bmU().a(this.mArrow, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.fWB, R.color.common_color_10067, 1, skinType);
        ap.setBackgroundResource(this.mDivider, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fWB.setVisibility(8);
            this.fWB.setText("");
            return;
        }
        this.fWB.setVisibility(0);
        this.fWB.setText(str);
    }
}
