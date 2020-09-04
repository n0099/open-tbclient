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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
import com.baidu.webkit.internal.ETAG;
import java.net.URISyntaxException;
/* loaded from: classes20.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView afB;
    private TextView fGY;
    private TbImageView hBn;
    private com.baidu.adp.lib.b.b jfH;
    private TextView jjI;
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
        this.jfH = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.afB = (TextView) findViewById(R.id.single_abstract);
        this.hBn = (TbImageView) findViewById(R.id.single_content_pic);
        this.hBn.setAutoChangeStyle(false);
        this.jjI = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.mDivider = findViewById(R.id.single_divider);
        this.fGY = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.jfH != null) {
                    SingleImageTextView.this.jfH.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0719a c0719a, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(R.dimen.ds30), 0, 0);
        if (c0719a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0719a.title)) {
                str = c0719a.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(c0719a.text)) {
                str2 = c0719a.text;
            }
            this.afB.setText(str2);
            if (!TextUtils.isEmpty(c0719a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        int i2;
                        if (c0719a != null && c0719a.url != null && c0719a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(c0719a.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        be.bju().b(tbPageContext, new String[]{c0719a.url});
                        if (c0719a.url != null && c0719a.url.contains("ForumGradePage")) {
                            aq u = new aq("c13783").u("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse = Uri.parse(c0719a.url);
                                String queryParameter = parse.getQueryParameter("forum_id");
                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                u.dD("fid", queryParameter);
                                u.dD("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(u);
                        }
                        if (c0719a.url != null && c0719a.url.contains("weeklygodview")) {
                            TiebaStatic.log(new aq("c13691").u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_source", 1));
                        }
                        if (c0719a.url != null && c0719a.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new aq("c13665").u("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", c0719a.fid);
                            com.baidu.tieba.im.data.d Lh = com.baidu.tieba.im.util.e.Lh(c0719a.jhF);
                            if (Lh != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", Lh.jlZ, "task_id", Lh.taskId, "loc", "0");
                                if ((c0719a.userType == 1 || c0719a.userType == 3) && !"0".equals(Lh.taskId)) {
                                    com.baidu.tieba.im.b.a.cIn().Lb(Lh.taskId);
                                }
                            }
                            aq aqVar = new aq("official_message_open_detail");
                            aqVar.u("msg_id", c0719a.jwu / 100);
                            aqVar.dD("official_id", c0719a.jwv);
                            aqVar.ai("official_type", c0719a.jww);
                            aqVar.u("operate_time", System.currentTimeMillis() / 1000);
                            aqVar.u("task_id", c0719a.taskId);
                            aqVar.dD("obj_params1", c0719a.url);
                            TiebaStatic.log(aqVar);
                        }
                        aq aqVar2 = new aq("c13784");
                        aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.dD("fid", c0719a.fid);
                        if (!TextUtils.isEmpty(c0719a.title)) {
                            if (!TextUtils.isEmpty(c0719a.url)) {
                                String str3 = null;
                                String[] split = c0719a.url.split("tid=");
                                if (split.length > 1) {
                                    int indexOf = split[1].indexOf(ETAG.ITEM_SEPARATOR);
                                    if (indexOf != -1) {
                                        str3 = split[1].substring(0, indexOf);
                                    } else {
                                        str3 = split[1].substring(0);
                                    }
                                }
                                aqVar2.dD("tid", str3);
                            }
                            if (c0719a.title.contains("互动量")) {
                                aqVar2.ai("obj_source", 2);
                                aqVar2.ai("obj_type", 9);
                            } else if (c0719a.title.contains("被加精")) {
                                aqVar2.ai("obj_source", 1);
                                aqVar2.ai("obj_type", 9);
                            } else if (c0719a.title.contains("热贴榜")) {
                                aqVar2.ai("obj_type", 8);
                            } else if (c0719a.userType == 4) {
                                aqVar2.ai("obj_type", 10);
                            } else if (c0719a.userType == 3) {
                                aqVar2.ai("obj_type", 5);
                            }
                        }
                        if (c0719a.jwv != null && c0719a.jwv.equals("4754917018")) {
                            aqVar2.delete("obj_type");
                            aqVar2.ai("obj_type", 9);
                            if (c0719a.url != null) {
                                if (c0719a.url.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (c0719a.url.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (c0719a.url.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = c0719a.url.contains("type=attention-common") ? 5 : -1;
                                }
                                if (i2 != -1) {
                                    aqVar2.delete("obj_source");
                                    aqVar2.ai("obj_source", i2);
                                }
                            }
                        }
                        TiebaStatic.log(aqVar2);
                    }
                });
            }
            if (!TextUtils.isEmpty(c0719a.src)) {
                this.hBn.setTag(c0719a.src);
                this.hBn.startLoad(c0719a.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.afB.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.afB.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.afB.setText("");
        this.hBn.setBackgroundDrawable(null);
        this.hBn.setImageDrawable(null);
        this.fGY.setText("");
        this.fGY.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jfH = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void qk(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.hBn.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b, 1, skinType);
        ap.setViewTextColor(this.afB, R.color.cp_cont_c, 1, skinType);
        ap.setViewTextColor(this.jjI, R.color.cp_cont_b, 1, skinType);
        ap.setBackgroundResource(this.mArrow, R.drawable.icon_ba_top_arrow_big, skinType);
        ap.setViewTextColor(this.fGY, R.color.common_color_10067, 1, skinType);
        ap.setBackgroundResource(this.mDivider, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fGY.setVisibility(8);
            this.fGY.setText("");
            return;
        }
        this.fGY.setVisibility(0);
        this.fGY.setText(str);
    }
}
