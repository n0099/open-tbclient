package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.l;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> eUY;
    private int eWz;
    private b jcb;
    private ArrayList<i> jcd = new ArrayList<>();
    private l jce;
    private int jcf;

    /* loaded from: classes8.dex */
    public interface b {
        void JW(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.eWz = 0;
        this.jcf = 0;
        this.eUY = tbPageContext;
        this.eWz = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.jcf = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jcd != null) {
            return this.jcd.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yh */
    public i getItem(int i) {
        if (this.jcd == null || i >= this.jcd.size()) {
            return null;
        }
        return this.jcd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).cAJ();
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
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.eUY.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.jci.setVisibility(0);
                cVar2.jcj.setVisibility(8);
                cVar2.jck.setVisibility(8);
                cVar2.jcl.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.jch = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.jci = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.jcj = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.jck = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.jcl = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.cAK() != null && bVar.cAK().size() > 0) {
                if (bVar.isLast() && bVar.cAL()) {
                    cVar.jch.setPadding(this.eWz, 0, this.eWz, this.jcf);
                    if (this.jce != null && !this.jce.isEmpty()) {
                        if (bVar.cAK().size() == 2) {
                            if (bVar.cAM().equals(this.eUY.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.jcl.setVisibility(8);
                                cVar.jck.setVisibility(8);
                            } else if (bVar.cAM().equals(this.eUY.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.jcl.setVisibility(8);
                                cVar.jck.setVisibility(0);
                                cVar.jck.aW(this.eUY.getResources().getString(R.string.tip_assist_apply), this.jce.cAV());
                                cVar.jck.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.jcb != null) {
                                            h.this.jcb.JW(h.this.jce.cAW());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.cAM().equals(this.eUY.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.jcj.setVisibility(8);
                            cVar.jcl.setVisibility(8);
                            cVar.jck.setVisibility(8);
                        } else if (bVar.cAM().equals(this.eUY.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.jcj.setVisibility(8);
                            cVar.jcl.setVisibility(0);
                            cVar.jck.setVisibility(8);
                            cVar.jcl.aW(this.eUY.getResources().getString(R.string.tip_assist_apply), this.jce.cAV());
                            cVar.jcl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.jcb != null) {
                                        h.this.jcb.JW(h.this.jce.cAW());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.jch.setPadding(this.eWz, 0, this.eWz, 0);
                    cVar.jck.setVisibility(8);
                    cVar.jcl.setVisibility(8);
                }
                cVar.jci.a(bVar.cAK().get(0));
                if (bVar.cAK().size() >= 2) {
                    cVar.jcj.a(bVar.cAK().get(1));
                    cVar.jcj.setVisibility(0);
                } else {
                    cVar.jcj.setVisibility(8);
                }
                this.eUY.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.erI = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.eUY.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void as(ArrayList<i> arrayList) {
        this.jcd = arrayList;
    }

    public void a(l lVar) {
        this.jce = lVar;
    }

    public void a(b bVar) {
        this.jcb = bVar;
    }

    /* loaded from: classes8.dex */
    public class c {
        RelativeLayout jch;
        BawuMemberInfoView jci;
        BawuMemberInfoView jcj;
        BawuManagerApplyInfoView jck;
        BawuManagerApplyInfoView jcl;

        public c() {
        }
    }

    /* loaded from: classes8.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes8.dex */
    public class a {
        View erI;

        public a() {
        }
    }
}
