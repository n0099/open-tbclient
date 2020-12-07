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
/* loaded from: classes23.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> eNx;
    private int eOV;
    private b iOA;
    private ArrayList<i> iOC = new ArrayList<>();
    private p iOD;
    private int iOE;

    /* loaded from: classes23.dex */
    public interface b {
        void Ky(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.eOV = 0;
        this.iOE = 0;
        this.eNx = tbPageContext;
        this.eOV = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.iOE = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iOC != null) {
            return this.iOC.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zq */
    public i getItem(int i) {
        if (this.iOC == null || i >= this.iOC.size()) {
            return null;
        }
        return this.iOC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).cAo();
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
                view = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.eNx.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.iOG.setVisibility(0);
                cVar2.iOH.setVisibility(8);
                cVar2.iOI.setVisibility(8);
                cVar2.iOJ.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.iOG = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.iOH = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.iOI = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.iOJ = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.cAp() != null && bVar.cAp().size() > 0) {
                if (bVar.isLast() && bVar.cAq()) {
                    cVar.mRoot.setPadding(this.eOV, 0, this.eOV, this.iOE);
                    if (this.iOD != null && !this.iOD.isEmpty()) {
                        if (bVar.cAp().size() == 2) {
                            if (bVar.cAr().equals(this.eNx.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.iOJ.setVisibility(8);
                                cVar.iOI.setVisibility(8);
                            } else if (bVar.cAr().equals(this.eNx.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.iOJ.setVisibility(8);
                                cVar.iOI.setVisibility(0);
                                cVar.iOI.aO(this.eNx.getResources().getString(R.string.tip_assist_apply), this.iOD.cAA());
                                cVar.iOI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.iOA != null) {
                                            h.this.iOA.Ky(h.this.iOD.cAB());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.cAr().equals(this.eNx.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.iOH.setVisibility(8);
                            cVar.iOJ.setVisibility(8);
                            cVar.iOI.setVisibility(8);
                        } else if (bVar.cAr().equals(this.eNx.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.iOH.setVisibility(8);
                            cVar.iOJ.setVisibility(0);
                            cVar.iOI.setVisibility(8);
                            cVar.iOJ.aO(this.eNx.getResources().getString(R.string.tip_assist_apply), this.iOD.cAA());
                            cVar.iOJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.iOA != null) {
                                        h.this.iOA.Ky(h.this.iOD.cAB());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.eOV, 0, this.eOV, 0);
                    cVar.iOI.setVisibility(8);
                    cVar.iOJ.setVisibility(8);
                }
                cVar.iOG.a(bVar.cAp().get(0));
                if (bVar.cAp().size() >= 2) {
                    cVar.iOH.a(bVar.cAp().get(1));
                    cVar.iOH.setVisibility(0);
                } else {
                    cVar.iOH.setVisibility(8);
                }
                this.eNx.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.elk = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.eNx.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void ay(ArrayList<i> arrayList) {
        this.iOC = arrayList;
    }

    public void a(p pVar) {
        this.iOD = pVar;
    }

    public void a(b bVar) {
        this.iOA = bVar;
    }

    /* loaded from: classes23.dex */
    public class c {
        BawuMemberInfoView iOG;
        BawuMemberInfoView iOH;
        BawuManagerApplyInfoView iOI;
        BawuManagerApplyInfoView iOJ;
        RelativeLayout mRoot;

        public c() {
        }
    }

    /* loaded from: classes23.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes23.dex */
    public class a {
        View elk;

        public a() {
        }
    }
}
