package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private int cqL;
    private b dxI;
    private ArrayList<i> dxK = new ArrayList<>();
    private p dxL;
    private int dxM;
    private TbPageContext<?> mContext;

    /* loaded from: classes3.dex */
    public interface b {
        void np(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.cqL = 0;
        this.dxM = 0;
        this.mContext = tbPageContext;
        this.cqL = l.h(tbPageContext.getPageActivity(), e.C0200e.ds24);
        this.dxM = l.h(tbPageContext.getPageActivity(), e.C0200e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dxK != null) {
            return this.dxK.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lt */
    public i getItem(int i) {
        if (this.dxK == null || i >= this.dxK.size()) {
            return null;
        }
        return this.dxK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).axy();
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
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(e.g.text_view_title);
                dVar2.mLine = view.findViewById(e.g.line_divider);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.dxP.setVisibility(0);
                cVar2.dxQ.setVisibility(8);
                cVar2.dxR.setVisibility(8);
                cVar2.dxS.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.dxO = (RelativeLayout) view.findViewById(e.g.bawu_item_member_root);
                cVar3.dxP = (BawuMemberInfoView) view.findViewById(e.g.left_member);
                cVar3.dxQ = (BawuMemberInfoView) view.findViewById(e.g.right_member);
                cVar3.dxR = (BawuManagerApplyInfoView) view.findViewById(e.g.left_manager_apply);
                cVar3.dxS = (BawuManagerApplyInfoView) view.findViewById(e.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.axz() != null && bVar.axz().size() > 0) {
                if (bVar.isLast()) {
                    cVar.dxO.setPadding(this.cqL, 0, this.cqL, this.dxM);
                    if (this.dxL != null && !this.dxL.isEmpty()) {
                        if (bVar.axz().size() == 2) {
                            if (bVar.axA().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                                cVar.dxS.setVisibility(8);
                                cVar.dxR.setVisibility(0);
                                cVar.dxR.aa(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dxL.axL());
                                cVar.dxR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dxI != null) {
                                            h.this.dxI.np(h.this.dxL.axO());
                                        }
                                    }
                                });
                            } else if (bVar.axA().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                                cVar.dxS.setVisibility(8);
                                cVar.dxR.setVisibility(0);
                                cVar.dxR.aa(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dxL.axN());
                                cVar.dxR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dxI != null) {
                                            h.this.dxI.np(h.this.dxL.axP());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.axA().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                            cVar.dxQ.setVisibility(8);
                            cVar.dxS.setVisibility(0);
                            cVar.dxR.setVisibility(8);
                            cVar.dxS.aa(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dxL.axL());
                            cVar.dxS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dxI != null) {
                                        h.this.dxI.np(h.this.dxL.axO());
                                    }
                                }
                            });
                        } else if (bVar.axA().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                            cVar.dxQ.setVisibility(8);
                            cVar.dxS.setVisibility(0);
                            cVar.dxR.setVisibility(8);
                            cVar.dxS.aa(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dxL.axN());
                            cVar.dxS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dxI != null) {
                                        h.this.dxI.np(h.this.dxL.axP());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.dxO.setPadding(this.cqL, 0, this.cqL, 0);
                    cVar.dxR.setVisibility(8);
                    cVar.dxS.setVisibility(8);
                }
                cVar.dxP.a(bVar.axz().get(0));
                if (bVar.axz().size() >= 2) {
                    cVar.dxQ.a(bVar.axz().get(1));
                    cVar.dxQ.setVisibility(0);
                } else {
                    cVar.dxQ.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.mDividerView = view.findViewById(e.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void N(ArrayList<i> arrayList) {
        this.dxK = arrayList;
    }

    public void a(p pVar) {
        this.dxL = pVar;
    }

    public void a(b bVar) {
        this.dxI = bVar;
    }

    /* loaded from: classes3.dex */
    public class c {
        RelativeLayout dxO;
        BawuMemberInfoView dxP;
        BawuMemberInfoView dxQ;
        BawuManagerApplyInfoView dxR;
        BawuManagerApplyInfoView dxS;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        View mLine;
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        View mDividerView;

        public a() {
        }
    }
}
