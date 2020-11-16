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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes25.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b jWq;
    private TbImageView jYm;
    private int jYn;
    private String jYo;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jWq = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.jWq != null) {
                    MultiImageTextBottomView.this.jWq.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.jYm = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.jYm.setAutoChangeStyle(false);
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
                            bf.bqF().b(tbPageContext, new String[]{c0766a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0766a.fid);
                                com.baidu.tieba.im.data.d MO = com.baidu.tieba.im.util.e.MO(MultiImageTextBottomView.this.jYo);
                                if (MO != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", MO.kcG, "task_id", MO.taskId, "loc", "" + MultiImageTextBottomView.this.jYn);
                                    if ((c0766a.userType == 1 || c0766a.userType == 3) && !"0".equals(MO.taskId)) {
                                        com.baidu.tieba.im.b.a.cUP().MI(MO.taskId);
                                    }
                                }
                                ar arVar = new ar("official_message_open_detail");
                                arVar.w("msg_id", c0766a.kna / 100);
                                arVar.dR("official_id", c0766a.knb);
                                arVar.ak("official_type", c0766a.knc);
                                arVar.w("operate_time", System.currentTimeMillis() / 1000);
                                arVar.w("task_id", c0766a.taskId);
                                arVar.dR("obj_params1", c0766a.url);
                                TiebaStatic.log(arVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0766a.src)) {
                this.jYm.setTag(c0766a.src);
                this.jYm.startLoad(c0766a.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.jYm.setBackgroundDrawable(null);
        this.jYm.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jWq = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.jYn = i;
    }

    public void setTaskInfo(String str) {
        this.jYo = str;
    }

    public void rC(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jYm.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
