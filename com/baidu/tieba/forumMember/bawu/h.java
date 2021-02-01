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
    private b jbN;
    private ArrayList<i> jbP = new ArrayList<>();
    private l jbQ;
    private int jbR;

    /* loaded from: classes8.dex */
    public interface b {
        void JV(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.eWz = 0;
        this.jbR = 0;
        this.eUY = tbPageContext;
        this.eWz = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.jbR = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jbP != null) {
            return this.jbP.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yh */
    public i getItem(int i) {
        if (this.jbP == null || i >= this.jbP.size()) {
            return null;
        }
        return this.jbP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).cAC();
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
                cVar2.jbU.setVisibility(0);
                cVar2.jbV.setVisibility(8);
                cVar2.jbW.setVisibility(8);
                cVar2.jbX.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.jbT = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.jbU = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.jbV = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.jbW = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.jbX = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.cAD() != null && bVar.cAD().size() > 0) {
                if (bVar.isLast() && bVar.cAE()) {
                    cVar.jbT.setPadding(this.eWz, 0, this.eWz, this.jbR);
                    if (this.jbQ != null && !this.jbQ.isEmpty()) {
                        if (bVar.cAD().size() == 2) {
                            if (bVar.cAF().equals(this.eUY.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.jbX.setVisibility(8);
                                cVar.jbW.setVisibility(8);
                            } else if (bVar.cAF().equals(this.eUY.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.jbX.setVisibility(8);
                                cVar.jbW.setVisibility(0);
                                cVar.jbW.aW(this.eUY.getResources().getString(R.string.tip_assist_apply), this.jbQ.cAO());
                                cVar.jbW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.jbN != null) {
                                            h.this.jbN.JV(h.this.jbQ.cAP());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.cAF().equals(this.eUY.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.jbV.setVisibility(8);
                            cVar.jbX.setVisibility(8);
                            cVar.jbW.setVisibility(8);
                        } else if (bVar.cAF().equals(this.eUY.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.jbV.setVisibility(8);
                            cVar.jbX.setVisibility(0);
                            cVar.jbW.setVisibility(8);
                            cVar.jbX.aW(this.eUY.getResources().getString(R.string.tip_assist_apply), this.jbQ.cAO());
                            cVar.jbX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.jbN != null) {
                                        h.this.jbN.JV(h.this.jbQ.cAP());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.jbT.setPadding(this.eWz, 0, this.eWz, 0);
                    cVar.jbW.setVisibility(8);
                    cVar.jbX.setVisibility(8);
                }
                cVar.jbU.a(bVar.cAD().get(0));
                if (bVar.cAD().size() >= 2) {
                    cVar.jbV.a(bVar.cAD().get(1));
                    cVar.jbV.setVisibility(0);
                } else {
                    cVar.jbV.setVisibility(8);
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
        this.jbP = arrayList;
    }

    public void a(l lVar) {
        this.jbQ = lVar;
    }

    public void a(b bVar) {
        this.jbN = bVar;
    }

    /* loaded from: classes8.dex */
    public class c {
        RelativeLayout jbT;
        BawuMemberInfoView jbU;
        BawuMemberInfoView jbV;
        BawuManagerApplyInfoView jbW;
        BawuManagerApplyInfoView jbX;

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
