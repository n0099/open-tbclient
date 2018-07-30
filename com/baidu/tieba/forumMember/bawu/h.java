package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private int ccq;
    private p diA;
    private int diB;
    private b dix;
    private ArrayList<i> diz = new ArrayList<>();
    private TbPageContext<?> mContext;

    /* loaded from: classes3.dex */
    public interface b {
        void mi(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.ccq = 0;
        this.diB = 0;
        this.mContext = tbPageContext;
        this.ccq = l.f(tbPageContext.getPageActivity(), d.e.ds24);
        this.diB = l.f(tbPageContext.getPageActivity(), d.e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.diz != null) {
            return this.diz.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kf */
    public i getItem(int i) {
        if (this.diz == null || i >= this.diz.size()) {
            return null;
        }
        return this.diz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).asR();
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
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(d.g.text_view_title);
                dVar2.mLine = view.findViewById(d.g.line_divider);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.diE.setVisibility(0);
                cVar2.diF.setVisibility(8);
                cVar2.diG.setVisibility(8);
                cVar2.diH.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.diD = (RelativeLayout) view.findViewById(d.g.bawu_item_member_root);
                cVar3.diE = (BawuMemberInfoView) view.findViewById(d.g.left_member);
                cVar3.diF = (BawuMemberInfoView) view.findViewById(d.g.right_member);
                cVar3.diG = (BawuManagerApplyInfoView) view.findViewById(d.g.left_manager_apply);
                cVar3.diH = (BawuManagerApplyInfoView) view.findViewById(d.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.asS() != null && bVar.asS().size() > 0) {
                if (bVar.isLast()) {
                    cVar.diD.setPadding(this.ccq, 0, this.ccq, this.diB);
                    if (this.diA != null && !this.diA.isEmpty()) {
                        if (bVar.asS().size() == 2) {
                            if (bVar.asT().equals(this.mContext.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                                cVar.diH.setVisibility(8);
                                cVar.diG.setVisibility(0);
                                cVar.diG.R(this.mContext.getResources().getString(d.j.tip_manager_apply), this.diA.ate());
                                cVar.diG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dix != null) {
                                            h.this.dix.mi(h.this.diA.ath());
                                        }
                                    }
                                });
                            } else if (bVar.asT().equals(this.mContext.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                                cVar.diH.setVisibility(8);
                                cVar.diG.setVisibility(0);
                                cVar.diG.R(this.mContext.getResources().getString(d.j.tip_assist_apply), this.diA.atg());
                                cVar.diG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dix != null) {
                                            h.this.dix.mi(h.this.diA.ati());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.asT().equals(this.mContext.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                            cVar.diF.setVisibility(8);
                            cVar.diH.setVisibility(0);
                            cVar.diG.setVisibility(8);
                            cVar.diH.R(this.mContext.getResources().getString(d.j.tip_manager_apply), this.diA.ate());
                            cVar.diH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dix != null) {
                                        h.this.dix.mi(h.this.diA.ath());
                                    }
                                }
                            });
                        } else if (bVar.asT().equals(this.mContext.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                            cVar.diF.setVisibility(8);
                            cVar.diH.setVisibility(0);
                            cVar.diG.setVisibility(8);
                            cVar.diH.R(this.mContext.getResources().getString(d.j.tip_assist_apply), this.diA.atg());
                            cVar.diH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dix != null) {
                                        h.this.dix.mi(h.this.diA.ati());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.diD.setPadding(this.ccq, 0, this.ccq, 0);
                    cVar.diG.setVisibility(8);
                    cVar.diH.setVisibility(8);
                }
                cVar.diE.a(bVar.asS().get(0));
                if (bVar.asS().size() >= 2) {
                    cVar.diF.a(bVar.asS().get(1));
                    cVar.diF.setVisibility(0);
                } else {
                    cVar.diF.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cUP = view.findViewById(d.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void N(ArrayList<i> arrayList) {
        this.diz = arrayList;
    }

    public void a(p pVar) {
        this.diA = pVar;
    }

    public void a(b bVar) {
        this.dix = bVar;
    }

    /* loaded from: classes3.dex */
    public class c {
        RelativeLayout diD;
        BawuMemberInfoView diE;
        BawuMemberInfoView diF;
        BawuManagerApplyInfoView diG;
        BawuManagerApplyInfoView diH;

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
        View cUP;

        public a() {
        }
    }
}
