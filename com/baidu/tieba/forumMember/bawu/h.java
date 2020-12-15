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
    private b iOC;
    private ArrayList<i> iOE = new ArrayList<>();
    private p iOF;
    private int iOG;

    /* loaded from: classes23.dex */
    public interface b {
        void Ky(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.eOV = 0;
        this.iOG = 0;
        this.eNx = tbPageContext;
        this.eOV = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.iOG = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iOE != null) {
            return this.iOE.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zq */
    public i getItem(int i) {
        if (this.iOE == null || i >= this.iOE.size()) {
            return null;
        }
        return this.iOE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).cAp();
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
                cVar2.iOI.setVisibility(0);
                cVar2.iOJ.setVisibility(8);
                cVar2.iOK.setVisibility(8);
                cVar2.iOL.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.iOI = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.iOJ = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.iOK = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.iOL = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.cAq() != null && bVar.cAq().size() > 0) {
                if (bVar.isLast() && bVar.cAr()) {
                    cVar.mRoot.setPadding(this.eOV, 0, this.eOV, this.iOG);
                    if (this.iOF != null && !this.iOF.isEmpty()) {
                        if (bVar.cAq().size() == 2) {
                            if (bVar.cAs().equals(this.eNx.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.iOL.setVisibility(8);
                                cVar.iOK.setVisibility(8);
                            } else if (bVar.cAs().equals(this.eNx.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.iOL.setVisibility(8);
                                cVar.iOK.setVisibility(0);
                                cVar.iOK.aO(this.eNx.getResources().getString(R.string.tip_assist_apply), this.iOF.cAB());
                                cVar.iOK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.iOC != null) {
                                            h.this.iOC.Ky(h.this.iOF.cAC());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.cAs().equals(this.eNx.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.iOJ.setVisibility(8);
                            cVar.iOL.setVisibility(8);
                            cVar.iOK.setVisibility(8);
                        } else if (bVar.cAs().equals(this.eNx.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.iOJ.setVisibility(8);
                            cVar.iOL.setVisibility(0);
                            cVar.iOK.setVisibility(8);
                            cVar.iOL.aO(this.eNx.getResources().getString(R.string.tip_assist_apply), this.iOF.cAB());
                            cVar.iOL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.iOC != null) {
                                        h.this.iOC.Ky(h.this.iOF.cAC());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.eOV, 0, this.eOV, 0);
                    cVar.iOK.setVisibility(8);
                    cVar.iOL.setVisibility(8);
                }
                cVar.iOI.a(bVar.cAq().get(0));
                if (bVar.cAq().size() >= 2) {
                    cVar.iOJ.a(bVar.cAq().get(1));
                    cVar.iOJ.setVisibility(0);
                } else {
                    cVar.iOJ.setVisibility(8);
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
        this.iOE = arrayList;
    }

    public void a(p pVar) {
        this.iOF = pVar;
    }

    public void a(b bVar) {
        this.iOC = bVar;
    }

    /* loaded from: classes23.dex */
    public class c {
        BawuMemberInfoView iOI;
        BawuMemberInfoView iOJ;
        BawuManagerApplyInfoView iOK;
        BawuManagerApplyInfoView iOL;
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
