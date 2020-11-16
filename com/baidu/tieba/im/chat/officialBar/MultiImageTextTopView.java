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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes25.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView gma;
    private com.baidu.adp.lib.b.b jWq;
    private TbImageView jYm;
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
        this.jWq = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.jYm = (TbImageView) findViewById(R.id.top_content_pic);
        this.jYm.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.gma = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.jWq != null) {
                    MultiImageTextTopView.this.jWq.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0766a c0766a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0766a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0766a.title)) {
                str = c0766a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0766a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0766a != null && !StringUtils.isNull(c0766a.url)) {
                            bf.bqF().b(tbPageContext, new String[]{c0766a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0766a.fid);
                                com.baidu.tieba.im.data.d MO = com.baidu.tieba.im.util.e.MO(c0766a.jYo);
                                if (MO != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", MO.kcG, "task_id", MO.taskId, "loc", "0");
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

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gma.setVisibility(8);
            this.gma.setText("");
            return;
        }
        this.gma.setVisibility(0);
        this.gma.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.jYm.setBackgroundDrawable(null);
        this.jYm.setImageDrawable(null);
        this.gma.setVisibility(8);
        this.gma.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jWq = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void rC(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jYm.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1, skinType);
        ap.setViewTextColor(this.gma, R.color.common_color_10067, 1, skinType);
    }
}
