package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class h extends BaseAdapter {
    private int dYC;
    private b fqn;
    private ArrayList<i> fqp = new ArrayList<>();
    private p fqq;
    private int fqr;
    private TbPageContext<?> mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void wK(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.dYC = 0;
        this.fqr = 0;
        this.mContext = tbPageContext;
        this.dYC = l.g(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.fqr = l.g(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqp != null) {
            return this.fqp.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rc */
    public i getItem(int i) {
        if (this.fqp == null || i >= this.fqp.size()) {
            return null;
        }
        return this.fqp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bkw();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        d dVar;
        if (getItemViewType(i) == 0) {
            if (view != null && (view.getTag() instanceof d)) {
                dVar = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.fqu.setVisibility(0);
                cVar2.fqv.setVisibility(8);
                cVar2.fqw.setVisibility(8);
                cVar2.fqx.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.fqt = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.fqu = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.fqv = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.fqw = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.fqx = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bkx() != null && bVar.bkx().size() > 0) {
                if (bVar.isLast() && bVar.bky()) {
                    cVar.fqt.setPadding(this.dYC, 0, this.dYC, this.fqr);
                    if (this.fqq != null && !this.fqq.isEmpty()) {
                        if (bVar.bkx().size() == 2) {
                            if (bVar.bkz().equals(this.mContext.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.fqx.setVisibility(8);
                                cVar.fqw.setVisibility(8);
                            } else if (bVar.bkz().equals(this.mContext.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.fqx.setVisibility(8);
                                cVar.fqw.setVisibility(0);
                                cVar.fqw.at(this.mContext.getResources().getString(R.string.tip_assist_apply), this.fqq.bkJ());
                                cVar.fqw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.fqn != null) {
                                            h.this.fqn.wK(h.this.fqq.bkK());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bkz().equals(this.mContext.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.fqv.setVisibility(8);
                            cVar.fqx.setVisibility(8);
                            cVar.fqw.setVisibility(8);
                        } else if (bVar.bkz().equals(this.mContext.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.fqv.setVisibility(8);
                            cVar.fqx.setVisibility(0);
                            cVar.fqw.setVisibility(8);
                            cVar.fqx.at(this.mContext.getResources().getString(R.string.tip_assist_apply), this.fqq.bkJ());
                            cVar.fqx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.fqn != null) {
                                        h.this.fqn.wK(h.this.fqq.bkK());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.fqt.setPadding(this.dYC, 0, this.dYC, 0);
                    cVar.fqw.setVisibility(8);
                    cVar.fqx.setVisibility(8);
                }
                cVar.fqu.a(bVar.bkx().get(0));
                if (bVar.bkx().size() >= 2) {
                    cVar.fqv.a(bVar.bkx().get(1));
                    cVar.fqv.setVisibility(0);
                } else {
                    cVar.fqv.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.bqE = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void U(ArrayList<i> arrayList) {
        this.fqp = arrayList;
    }

    public void a(p pVar) {
        this.fqq = pVar;
    }

    public void a(b bVar) {
        this.fqn = bVar;
    }

    /* loaded from: classes5.dex */
    public class c {
        RelativeLayout fqt;
        BawuMemberInfoView fqu;
        BawuMemberInfoView fqv;
        BawuManagerApplyInfoView fqw;
        BawuManagerApplyInfoView fqx;

        public c() {
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes5.dex */
    public class a {
        View bqE;

        public a() {
        }
    }
}
