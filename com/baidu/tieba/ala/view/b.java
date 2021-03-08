package com.baidu.tieba.ala.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.BdGridView;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private boolean bOS;
    private TextView bPa;
    private BdGridView bPd;
    private long bwn;
    private long gqI;
    private com.baidu.tieba.ala.adapter.b ikb;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    public b(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_activity_choose_feedback_reason_layout, (ViewGroup) null);
        this.bPd = (BdGridView) this.mView.findViewById(a.f.id_feedback_gridview);
        this.bPa = (TextView) this.mView.findViewById(a.f.id_feenback_confirm_btn);
        this.bPa.setEnabled(false);
        this.bPa.setOnClickListener(this);
        this.ikb = new com.baidu.tieba.ala.adapter.b(this.mPageContext);
        this.bPd.setAdapter((ListAdapter) this.ikb);
        this.bPd.setOnItemClickListener(new a());
    }

    public void b(long j, long j2, long j3, boolean z, boolean z2) {
        this.bwn = j;
        this.gqI = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bOS = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.ala.data.b item = ((com.baidu.tieba.ala.adapter.b) adapterView.getAdapter()).getItem(i);
            if (item != null) {
                if (item.Vf() != 0) {
                    if (b.this.ikb.Vd() == i) {
                        b.this.ikb.eY(-1);
                        b.this.ikb.notifyDataSetChanged();
                        b.this.bPa.setEnabled(false);
                        return;
                    }
                    b.this.ikb.eY(i);
                    b.this.ikb.notifyDataSetChanged();
                    b.this.bPa.setEnabled(true);
                    return;
                }
                com.baidu.live.d.h hVar = new com.baidu.live.d.h(b.this.mPageContext.getPageActivity());
                hVar.a(b.this.bwn, b.this.gqI, b.this.mUserId, b.this.mIsHost);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hVar));
                b.this.mPageContext.getPageActivity().finish();
            }
        }
    }

    public View getView() {
        return this.mView;
    }

    public void onDestroy() {
    }

    public void setData(List<com.baidu.tieba.ala.data.b> list) {
        this.ikb.setData(list);
    }

    public com.baidu.tieba.ala.data.b cpy() {
        if (this.ikb == null || this.ikb.Vd() < 0) {
            return null;
        }
        return this.ikb.getItem(this.ikb.Vd());
    }
}
