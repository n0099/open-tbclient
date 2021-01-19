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
/* loaded from: classes7.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b krZ;
    private TbImageView ktU;
    private int ktV;
    private String ktW;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.krZ = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.krZ != null) {
                    MultiImageTextBottomView.this.krZ.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.ktU = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.ktU.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0758a c0758a, View view, final int i) {
        if (c0758a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0758a.title)) {
                str = c0758a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0758a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0758a != null && !StringUtils.isNull(c0758a.url)) {
                            be.bsB().b(tbPageContext, new String[]{c0758a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0758a.fid);
                                com.baidu.tieba.im.data.d Mv = com.baidu.tieba.im.util.c.Mv(MultiImageTextBottomView.this.ktW);
                                if (Mv != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", Mv.kww, "task_id", Mv.taskId, "loc", "" + MultiImageTextBottomView.this.ktV);
                                    if ((c0758a.userType == 1 || c0758a.userType == 3) && !"0".equals(Mv.taskId)) {
                                        com.baidu.tieba.im.b.a.cVY().Mq(Mv.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.w("msg_id", c0758a.kBh / 100);
                                aqVar.dW("official_id", c0758a.kBi);
                                aqVar.an("official_type", c0758a.kBj);
                                aqVar.w("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.w("task_id", c0758a.taskId);
                                aqVar.dW("obj_params1", c0758a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0758a.src)) {
                this.ktU.setTag(c0758a.src);
                this.ktU.startLoad(c0758a.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.ktU.setBackgroundDrawable(null);
        this.ktU.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.krZ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.ktV = i;
    }

    public void setTaskInfo(String str) {
        this.ktW = str;
    }

    public void st(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.ktU.setAutoChangeStyle(z);
        ao.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
