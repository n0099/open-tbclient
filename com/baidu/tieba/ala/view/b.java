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
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private long blh;
    private boolean eaR;
    private TextView fJN;
    private long fKh;
    private BdGridView gQm;
    private com.baidu.tieba.ala.adapter.b hta;
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
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_activity_choose_feedback_reason_layout, (ViewGroup) null);
        this.gQm = (BdGridView) this.mView.findViewById(a.g.id_feedback_gridview);
        this.fJN = (TextView) this.mView.findViewById(a.g.id_feenback_confirm_btn);
        this.fJN.setEnabled(false);
        this.fJN.setOnClickListener(this);
        this.hta = new com.baidu.tieba.ala.adapter.b(this.mPageContext);
        this.gQm.setAdapter((ListAdapter) this.hta);
        this.gQm.setOnItemClickListener(new a());
    }

    public void b(long j, long j2, long j3, boolean z, boolean z2) {
        this.blh = j;
        this.fKh = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.eaR = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.ala.data.b item = ((com.baidu.tieba.ala.adapter.b) adapterView.getAdapter()).getItem(i);
            if (item != null) {
                if (item.bME() != 0) {
                    if (b.this.hta.bIc() == i) {
                        b.this.hta.tf(-1);
                        b.this.hta.notifyDataSetChanged();
                        b.this.fJN.setEnabled(false);
                        return;
                    }
                    b.this.hta.tf(i);
                    b.this.hta.notifyDataSetChanged();
                    b.this.fJN.setEnabled(true);
                    return;
                }
                com.baidu.live.b.g gVar = new com.baidu.live.b.g(b.this.mPageContext.getPageActivity());
                gVar.a(b.this.blh, b.this.fKh, b.this.mUserId, b.this.mIsHost);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
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
        this.hta.setData(list);
    }

    public com.baidu.tieba.ala.data.b cfT() {
        if (this.hta == null || this.hta.bIc() < 0) {
            return null;
        }
        return this.hta.getItem(this.hta.bIc());
    }
}
