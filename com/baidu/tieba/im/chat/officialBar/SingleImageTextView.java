package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView cOs;
    private TbImageView dnD;
    private TextView dnM;
    private com.baidu.adp.lib.c.b eBb;
    private TextView eEg;
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
        this.eBb = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(e.h.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(e.g.single_title);
        this.cOs = (TextView) findViewById(e.g.single_abstract);
        this.dnD = (TbImageView) findViewById(e.g.single_content_pic);
        this.dnD.setAutoChangeStyle(false);
        this.eEg = (TextView) findViewById(e.g.read_all);
        this.mArrow = (ImageView) findViewById(e.g.arrow);
        this.mDivider = findViewById(e.g.single_divider);
        this.dnM = (TextView) findViewById(e.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.eBb != null) {
                    SingleImageTextView.this.eBb.b(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(e.C0200e.ds30), 0, 0);
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(aVar.text)) {
                str2 = aVar.text;
            }
            this.cOs.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ay.Db().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", AiAppsUBCStatistic.TYPE_CLICK, 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d qb = com.baidu.tieba.im.util.e.qb(aVar.eCQ);
                            if (qb != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", AiAppsUBCStatistic.TYPE_CLICK, 1, "task_type", qb.eGB, "task_id", qb.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(qb.taskId)) {
                                    com.baidu.tieba.im.b.a.aSv().pV(qb.taskId);
                                }
                            }
                            am amVar = new am("official_message_open_detail");
                            amVar.h("msg_id", aVar.eCX / 100);
                            amVar.ax("official_id", aVar.eCY);
                            amVar.x("official_type", aVar.eCZ);
                            amVar.h("operate_time", System.currentTimeMillis() / 1000);
                            amVar.h("task_id", aVar.taskId);
                            amVar.ax("obj_params1", aVar.url);
                            TiebaStatic.log(amVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.dnD.setTag(aVar.src);
                this.dnD.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.cOs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.cOs.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.cOs.setText("");
        this.dnD.setBackgroundDrawable(null);
        this.dnD.setImageDrawable(null);
        this.dnM.setText("");
        this.dnM.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eBb = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void ie(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.dnD.setAutoChangeStyle(z);
        al.b(this.mTitle, e.d.common_color_10039, 1, skinType);
        al.b(this.cOs, e.d.cp_cont_c, 1, skinType);
        al.b(this.eEg, e.d.common_color_10039, 1, skinType);
        al.d(this.mArrow, e.f.icon_ba_top_arrow_big, skinType);
        al.b(this.dnM, e.d.common_color_10067, 1, skinType);
        al.d(this.mDivider, e.f.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dnM.setVisibility(8);
            this.dnM.setText("");
            return;
        }
        this.dnM.setVisibility(0);
        this.dnM.setText(str);
    }
}
