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
/* loaded from: classes25.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView afT;
    private TextView fKk;
    private TbImageView hIp;
    private com.baidu.adp.lib.b.b jon;
    private TextView jsm;
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
        this.jon = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.afT = (TextView) findViewById(R.id.single_abstract);
        this.hIp = (TbImageView) findViewById(R.id.single_content_pic);
        this.hIp.setAutoChangeStyle(false);
        this.hIp.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.hIp.setConrers(15);
        this.jsm = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.mDivider = findViewById(R.id.single_divider);
        this.fKk = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.jon != null) {
                    SingleImageTextView.this.jon.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0716a c0716a, View view, final int i) {
        if (c0716a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0716a.title)) {
                str = c0716a.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(c0716a.text)) {
                str2 = c0716a.text;
            }
            this.afT.setText(str2);
            if (!TextUtils.isEmpty(c0716a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        int i2;
                        if (c0716a != null && c0716a.url != null && c0716a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(c0716a.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        be.bkp().b(tbPageContext, new String[]{c0716a.url});
                        if (c0716a.url != null && c0716a.url.contains("ForumGradePage")) {
                            aq u = new aq("c13783").u("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse = Uri.parse(c0716a.url);
                                String queryParameter = parse.getQueryParameter("forum_id");
                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                u.dF("fid", queryParameter);
                                u.dF("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(u);
                        }
                        if (c0716a.url != null && c0716a.url.contains("weeklygodview")) {
                            TiebaStatic.log(new aq("c13691").u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_source", 1));
                        }
                        if (c0716a.url != null && c0716a.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new aq("c13665").u("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", c0716a.fid);
                            com.baidu.tieba.im.data.d LJ = com.baidu.tieba.im.util.e.LJ(c0716a.jql);
                            if (LJ != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", LJ.juD, "task_id", LJ.taskId, "loc", "0");
                                if ((c0716a.userType == 1 || c0716a.userType == 3) && !"0".equals(LJ.taskId)) {
                                    com.baidu.tieba.im.b.a.cLT().LD(LJ.taskId);
                                }
                            }
                            aq aqVar = new aq("official_message_open_detail");
                            aqVar.u("msg_id", c0716a.jEW / 100);
                            aqVar.dF("official_id", c0716a.jEX);
                            aqVar.ai("official_type", c0716a.jEY);
                            aqVar.u("operate_time", System.currentTimeMillis() / 1000);
                            aqVar.u("task_id", c0716a.taskId);
                            aqVar.dF("obj_params1", c0716a.url);
                            TiebaStatic.log(aqVar);
                        }
                        aq aqVar2 = new aq("c13784");
                        aqVar2.u(Constants.EXTRA_SERVICE, c0716a.serviceId);
                        aqVar2.u("task_id", c0716a.taskId);
                        aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.dF("fid", c0716a.fid);
                        if (!TextUtils.isEmpty(c0716a.title)) {
                            if (!TextUtils.isEmpty(c0716a.url)) {
                                String str3 = null;
                                String[] split = c0716a.url.split("tid=");
                                if (split.length > 1) {
                                    int indexOf = split[1].indexOf(ETAG.ITEM_SEPARATOR);
                                    if (indexOf != -1) {
                                        str3 = split[1].substring(0, indexOf);
                                    } else {
                                        str3 = split[1].substring(0);
                                    }
                                }
                                aqVar2.dF("tid", str3);
                            }
                            if (c0716a.title.contains("互动量")) {
                                aqVar2.ai("obj_source", 2);
                                aqVar2.ai("obj_type", 9);
                            } else if (c0716a.title.contains("被加精")) {
                                aqVar2.ai("obj_source", 1);
                                aqVar2.ai("obj_type", 9);
                            } else if (c0716a.title.contains("热贴榜")) {
                                aqVar2.ai("obj_type", 8);
                            } else if (c0716a.userType == 4) {
                                aqVar2.ai("obj_type", 10);
                            } else if (c0716a.userType == 3) {
                                aqVar2.ai("obj_type", 5);
                            }
                        }
                        if (c0716a.jEX != null && c0716a.jEX.equals("4754917018")) {
                            aqVar2.delete("obj_type");
                            aqVar2.ai("obj_type", 9);
                            if (c0716a.url != null) {
                                if (c0716a.url.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (c0716a.url.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (c0716a.url.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = c0716a.url.contains("type=attention-common") ? 5 : -1;
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
            if (!TextUtils.isEmpty(c0716a.src)) {
                this.hIp.setTag(c0716a.src);
                this.hIp.startLoad(c0716a.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.afT.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.afT.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.afT.setText("");
        this.hIp.setBackgroundDrawable(null);
        this.hIp.setImageDrawable(null);
        this.fKk.setText("");
        this.fKk.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jon = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void qs(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.hIp.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b, 1, skinType);
        ap.setViewTextColor(this.afT, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.jsm, R.color.cp_cont_j, 1, skinType);
        SvgManager.bkl().a(this.mArrow, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.fKk, R.color.common_color_10067, 1, skinType);
        ap.setBackgroundResource(this.mDivider, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fKk.setVisibility(8);
            this.fKk.setText("");
            return;
        }
        this.fKk.setVisibility(0);
        this.fKk.setText(str);
    }
}
