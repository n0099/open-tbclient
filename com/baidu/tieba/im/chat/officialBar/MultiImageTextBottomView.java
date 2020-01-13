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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes11.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b hqp;
    private TbImageView hrZ;
    private int hsa;
    private String hsb;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hqp = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.hqp != null) {
                    MultiImageTextBottomView.this.hqp.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.hrZ = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.hrZ.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aVar != null && !StringUtils.isNull(aVar.url)) {
                            ba.aEt().b(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", aVar.fid);
                                com.baidu.tieba.im.data.d Dm = com.baidu.tieba.im.util.e.Dm(MultiImageTextBottomView.this.hsb);
                                if (Dm != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", Dm.hvI, "task_id", Dm.taskId, "loc", "" + MultiImageTextBottomView.this.hsa);
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(Dm.taskId)) {
                                        com.baidu.tieba.im.b.a.bWB().Dg(Dm.taskId);
                                    }
                                }
                                an anVar = new an("official_message_open_detail");
                                anVar.s("msg_id", aVar.hsi / 100);
                                anVar.cp("official_id", aVar.hsj);
                                anVar.Z("official_type", aVar.hsk);
                                anVar.s("operate_time", System.currentTimeMillis() / 1000);
                                anVar.s("task_id", aVar.taskId);
                                anVar.cp("obj_params1", aVar.url);
                                TiebaStatic.log(anVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.hrZ.setTag(aVar.src);
                this.hrZ.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.hrZ.setBackgroundDrawable(null);
        this.hrZ.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.hqp = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.hsa = i;
    }

    public void setTaskInfo(String str) {
        this.hsb = str;
    }

    public void nf(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.hrZ.setAutoChangeStyle(z);
        am.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
