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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
import com.baidu.webkit.internal.ETAG;
import java.net.URISyntaxException;
/* loaded from: classes20.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView aeq;
    private TextView fvC;
    private TbImageView hoq;
    private com.baidu.adp.lib.b.b iQC;
    private TextView iUB;
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
        this.iQC = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.aeq = (TextView) findViewById(R.id.single_abstract);
        this.hoq = (TbImageView) findViewById(R.id.single_content_pic);
        this.hoq.setAutoChangeStyle(false);
        this.iUB = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.mDivider = findViewById(R.id.single_divider);
        this.fvC = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.iQC != null) {
                    SingleImageTextView.this.iQC.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0667a c0667a, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(R.dimen.ds30), 0, 0);
        if (c0667a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0667a.title)) {
                str = c0667a.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(c0667a.text)) {
                str2 = c0667a.text;
            }
            this.aeq.setText(str2);
            if (!TextUtils.isEmpty(c0667a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0667a != null && c0667a.url != null && c0667a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(c0667a.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        bd.baV().b(tbPageContext, new String[]{c0667a.url});
                        if (c0667a.url != null && c0667a.url.contains("ForumGradePage")) {
                            ap t = new ap("c13783").t("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse = Uri.parse(c0667a.url);
                                String queryParameter = parse.getQueryParameter("forum_id");
                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                t.dn("fid", queryParameter);
                                t.dn("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(t);
                        }
                        if (c0667a.url != null && c0667a.url.contains("weeklygodview")) {
                            TiebaStatic.log(new ap("c13691").t("uid", TbadkCoreApplication.getCurrentAccountId()).ah("obj_source", 1));
                        }
                        if (c0667a.url != null && c0667a.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new ap("c13665").t("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", c0667a.fid);
                            com.baidu.tieba.im.data.d Io = com.baidu.tieba.im.util.e.Io(c0667a.iSA);
                            if (Io != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", Io.iWS, "task_id", Io.taskId, "loc", "0");
                                if ((c0667a.userType == 1 || c0667a.userType == 3) && !"0".equals(Io.taskId)) {
                                    com.baidu.tieba.im.b.a.cxv().Ii(Io.taskId);
                                }
                            }
                            ap apVar = new ap("official_message_open_detail");
                            apVar.t("msg_id", c0667a.jhm / 100);
                            apVar.dn("official_id", c0667a.jhn);
                            apVar.ah("official_type", c0667a.jho);
                            apVar.t("operate_time", System.currentTimeMillis() / 1000);
                            apVar.t("task_id", c0667a.taskId);
                            apVar.dn("obj_params1", c0667a.url);
                            TiebaStatic.log(apVar);
                        }
                        ap apVar2 = new ap("c13784");
                        apVar2.t("uid", TbadkApplication.getCurrentAccountId());
                        apVar2.dn("fid", c0667a.fid);
                        if (!TextUtils.isEmpty(c0667a.title)) {
                            if (!TextUtils.isEmpty(c0667a.url)) {
                                String str3 = null;
                                String[] split = c0667a.url.split("tid=");
                                if (split.length > 1) {
                                    int indexOf = split[1].indexOf(ETAG.ITEM_SEPARATOR);
                                    if (indexOf != -1) {
                                        str3 = split[1].substring(0, indexOf);
                                    } else {
                                        str3 = split[1].substring(0);
                                    }
                                }
                                apVar2.dn("tid", str3);
                            }
                            if (c0667a.title.contains("互动量")) {
                                apVar2.ah("obj_source", 2);
                                apVar2.ah("obj_type", 9);
                            } else if (c0667a.title.contains("被加精")) {
                                apVar2.ah("obj_source", 1);
                                apVar2.ah("obj_type", 9);
                            } else if (c0667a.title.contains("热贴榜")) {
                                apVar2.ah("obj_type", 8);
                            } else if (c0667a.userType == 4) {
                                apVar2.ah("obj_type", 10);
                            } else if (c0667a.userType == 3) {
                                apVar2.ah("obj_type", 5);
                            }
                        }
                        TiebaStatic.log(apVar2);
                    }
                });
            }
            if (!TextUtils.isEmpty(c0667a.src)) {
                this.hoq.setTag(c0667a.src);
                this.hoq.startLoad(c0667a.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.aeq.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.aeq.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.aeq.setText("");
        this.hoq.setBackgroundDrawable(null);
        this.hoq.setImageDrawable(null);
        this.fvC.setText("");
        this.fvC.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.iQC = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void pC(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.hoq.setAutoChangeStyle(z);
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_b, 1, skinType);
        ao.setViewTextColor(this.aeq, R.color.cp_cont_c, 1, skinType);
        ao.setViewTextColor(this.iUB, R.color.cp_cont_b, 1, skinType);
        ao.setBackgroundResource(this.mArrow, R.drawable.icon_ba_top_arrow_big, skinType);
        ao.setViewTextColor(this.fvC, R.color.common_color_10067, 1, skinType);
        ao.setBackgroundResource(this.mDivider, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fvC.setVisibility(8);
            this.fvC.setText("");
            return;
        }
        this.fvC.setVisibility(0);
        this.fvC.setText(str);
    }
}
