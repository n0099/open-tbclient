package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
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
public class MultiImageTextTopView extends RelativeLayout {
    private TextView cXR;
    private com.baidu.adp.lib.c.b ecR;
    private TbImageView eeD;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ecR = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.i.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.eeD = (TbImageView) findViewById(d.g.top_content_pic);
        this.eeD.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(d.g.top_title);
        this.cXR = (TextView) findViewById(d.g.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.ecR != null) {
                    MultiImageTextTopView.this.ecR.b(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30));
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aVar != null && !StringUtils.isNull(aVar.url)) {
                            ay.zG().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d oO = com.baidu.tieba.im.util.e.oO(aVar.eeF);
                                if (oO != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", oO.eis, "task_id", oO.taskId, "loc", "0");
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
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.eeD.setTag(aVar.src);
                this.eeD.startLoad(aVar.src, 10, false);
            }
        }
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

    public void reset() {
        this.mTitle.setText("");
        this.eeD.setBackgroundDrawable(null);
        this.eeD.setImageDrawable(null);
        this.cXR.setVisibility(8);
        this.cXR.setText("");
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
        this.eeD.setAutoChangeStyle(z);
        al.b(this.mTitle, d.C0141d.cp_cont_g, 1, skinType);
        al.b(this.cXR, d.C0141d.common_color_10067, 1, skinType);
    }
}
