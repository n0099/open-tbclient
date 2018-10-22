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
    private TextView cNm;
    private TextView dmH;
    private TbImageView dmy;
    private TextView eCN;
    private com.baidu.adp.lib.c.b ezI;
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
        this.ezI = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(e.h.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(e.g.single_title);
        this.cNm = (TextView) findViewById(e.g.single_abstract);
        this.dmy = (TbImageView) findViewById(e.g.single_content_pic);
        this.dmy.setAutoChangeStyle(false);
        this.eCN = (TextView) findViewById(e.g.read_all);
        this.mArrow = (ImageView) findViewById(e.g.arrow);
        this.mDivider = findViewById(e.g.single_divider);
        this.dmH = (TextView) findViewById(e.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.ezI != null) {
                    SingleImageTextView.this.ezI.b(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(e.C0175e.ds30), 0, 0);
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
            this.cNm.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ay.CU().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", AiAppsUBCStatistic.TYPE_CLICK, 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d qa = com.baidu.tieba.im.util.e.qa(aVar.eBx);
                            if (qa != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", AiAppsUBCStatistic.TYPE_CLICK, 1, "task_type", qa.eFi, "task_id", qa.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(qa.taskId)) {
                                    com.baidu.tieba.im.b.a.aSY().pU(qa.taskId);
                                }
                            }
                            am amVar = new am("official_message_open_detail");
                            amVar.h("msg_id", aVar.eBE / 100);
                            amVar.ax("official_id", aVar.eBF);
                            amVar.x("official_type", aVar.eBG);
                            amVar.h("operate_time", System.currentTimeMillis() / 1000);
                            amVar.h("task_id", aVar.taskId);
                            amVar.ax("obj_params1", aVar.url);
                            TiebaStatic.log(amVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.dmy.setTag(aVar.src);
                this.dmy.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.cNm.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.cNm.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.cNm.setText("");
        this.dmy.setBackgroundDrawable(null);
        this.dmy.setImageDrawable(null);
        this.dmH.setText("");
        this.dmH.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ezI = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void hV(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.dmy.setAutoChangeStyle(z);
        al.b(this.mTitle, e.d.common_color_10039, 1, skinType);
        al.b(this.cNm, e.d.cp_cont_c, 1, skinType);
        al.b(this.eCN, e.d.common_color_10039, 1, skinType);
        al.d(this.mArrow, e.f.icon_ba_top_arrow_big, skinType);
        al.b(this.dmH, e.d.common_color_10067, 1, skinType);
        al.d(this.mDivider, e.f.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dmH.setVisibility(8);
            this.dmH.setText("");
            return;
        }
        this.dmH.setVisibility(0);
        this.dmH.setText(str);
    }
}
