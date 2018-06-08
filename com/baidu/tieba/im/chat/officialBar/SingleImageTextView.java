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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class SingleImageTextView extends RelativeLayout {
    private View bFh;
    private TbImageView cXI;
    private TextView cXR;
    private TextView cyG;
    private com.baidu.adp.lib.c.b ecR;
    private TextView efX;
    private ImageView mArrow;
    private Context mContext;
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
        this.ecR = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.i.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.single_title);
        this.cyG = (TextView) findViewById(d.g.single_abstract);
        this.cXI = (TbImageView) findViewById(d.g.single_content_pic);
        this.cXI.setAutoChangeStyle(false);
        this.efX = (TextView) findViewById(d.g.read_all);
        this.mArrow = (ImageView) findViewById(d.g.arrow);
        this.bFh = findViewById(d.g.single_divider);
        this.cXR = (TextView) findViewById(d.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.ecR != null) {
                    SingleImageTextView.this.ecR.b(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(d.e.ds30), 0, 0);
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
            this.cyG.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ay.zG().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d oO = com.baidu.tieba.im.util.e.oO(aVar.eeF);
                            if (oO != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", oO.eis, "task_id", oO.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(oO.taskId)) {
                                    com.baidu.tieba.im.b.a.aLS().oI(oO.taskId);
                                }
                            }
                            am amVar = new am("official_message_open_detail");
                            amVar.f("msg_id", aVar.eeM / 100);
                            amVar.ah("official_id", aVar.eeN);
                            amVar.r("official_type", aVar.eeO);
                            amVar.f("operate_time", System.currentTimeMillis() / 1000);
                            amVar.f("task_id", aVar.taskId);
                            amVar.ah("obj_params1", aVar.url);
                            TiebaStatic.log(amVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.cXI.setTag(aVar.src);
                this.cXI.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.cyG.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.cyG.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.cyG.setText("");
        this.cXI.setBackgroundDrawable(null);
        this.cXI.setImageDrawable(null);
        this.cXR.setText("");
        this.cXR.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ecR = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gS(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.cXI.setAutoChangeStyle(z);
        al.b(this.mTitle, d.C0141d.common_color_10039, 1, skinType);
        al.b(this.cyG, d.C0141d.cp_cont_c, 1, skinType);
        al.b(this.efX, d.C0141d.common_color_10039, 1, skinType);
        al.d(this.mArrow, d.f.icon_ba_top_arrow_big, skinType);
        al.b(this.cXR, d.C0141d.common_color_10067, 1, skinType);
        al.d(this.bFh, d.f.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cXR.setVisibility(8);
            this.cXR.setText("");
            return;
        }
        this.cXR.setVisibility(0);
        this.cXR.setText(str);
    }
}
