package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes8.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b kwE;
    private int kyA;
    private String kyB;
    private TbImageView kyz;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kwE = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.kwE != null) {
                    MultiImageTextBottomView.this.kwE.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.kyz = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.kyz.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0766a c0766a, View view, final int i) {
        if (c0766a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0766a.title)) {
                str = c0766a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0766a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0766a != null && !StringUtils.isNull(c0766a.url)) {
                            be.bwu().b(tbPageContext, new String[]{c0766a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0766a.fid);
                                com.baidu.tieba.im.data.d ND = com.baidu.tieba.im.util.c.ND(MultiImageTextBottomView.this.kyB);
                                if (ND != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", ND.kBb, "task_id", ND.taskId, "loc", "" + MultiImageTextBottomView.this.kyA);
                                    if ((c0766a.userType == 1 || c0766a.userType == 3) && !"0".equals(ND.taskId)) {
                                        com.baidu.tieba.im.b.a.cZP().Ny(ND.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.w("msg_id", c0766a.kFM / 100);
                                aqVar.dX("official_id", c0766a.kFN);
                                aqVar.an("official_type", c0766a.kFO);
                                aqVar.w("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.w("task_id", c0766a.taskId);
                                aqVar.dX("obj_params1", c0766a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0766a.src)) {
                this.kyz.setTag(c0766a.src);
                this.kyz.startLoad(c0766a.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.kyz.setBackgroundDrawable(null);
        this.kyz.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kwE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.kyA = i;
    }

    public void setTaskInfo(String str) {
        this.kyB = str;
    }

    public void sx(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.kyz.setAutoChangeStyle(z);
        ao.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
