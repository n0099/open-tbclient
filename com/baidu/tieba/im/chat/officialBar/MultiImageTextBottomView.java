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
/* loaded from: classes3.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private TbImageView gBh;
    private int gBi;
    private String gBj;
    private com.baidu.adp.lib.c.b gzv;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzv = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.gzv != null) {
                    MultiImageTextBottomView.this.gzv.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.gBh = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.gBh.setAutoChangeStyle(false);
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
                            ba.amQ().b(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", aVar.fid);
                                com.baidu.tieba.im.data.d yt = com.baidu.tieba.im.util.e.yt(MultiImageTextBottomView.this.gBj);
                                if (yt != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", yt.gET, "task_id", yt.taskId, "loc", "" + MultiImageTextBottomView.this.gBi);
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(yt.taskId)) {
                                        com.baidu.tieba.im.b.a.bEi().yn(yt.taskId);
                                    }
                                }
                                an anVar = new an("official_message_open_detail");
                                anVar.p("msg_id", aVar.gBr / 100);
                                anVar.bS("official_id", aVar.gBs);
                                anVar.O("official_type", aVar.gBt);
                                anVar.p("operate_time", System.currentTimeMillis() / 1000);
                                anVar.p("task_id", aVar.taskId);
                                anVar.bS("obj_params1", aVar.url);
                                TiebaStatic.log(anVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.gBh.setTag(aVar.src);
                this.gBh.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.gBh.setBackgroundDrawable(null);
        this.gBh.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gzv = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.gBi = i;
    }

    public void setTaskInfo(String str) {
        this.gBj = str;
    }

    public void lF(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.gBh.setAutoChangeStyle(z);
        am.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
