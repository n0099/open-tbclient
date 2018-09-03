package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private int cco;
    private b div;
    private ArrayList<i> dix = new ArrayList<>();
    private p diy;
    private int diz;
    private TbPageContext<?> mContext;

    /* loaded from: classes3.dex */
    public interface b {
        void mk(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.cco = 0;
        this.diz = 0;
        this.mContext = tbPageContext;
        this.cco = l.f(tbPageContext.getPageActivity(), f.e.ds24);
        this.diz = l.f(tbPageContext.getPageActivity(), f.e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dix != null) {
            return this.dix.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ke */
    public i getItem(int i) {
        if (this.dix == null || i >= this.dix.size()) {
            return null;
        }
        return this.dix.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).asQ();
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
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(f.g.text_view_title);
                dVar2.mLine = view.findViewById(f.g.line_divider);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.diC.setVisibility(0);
                cVar2.diD.setVisibility(8);
                cVar2.diE.setVisibility(8);
                cVar2.diF.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.diB = (RelativeLayout) view.findViewById(f.g.bawu_item_member_root);
                cVar3.diC = (BawuMemberInfoView) view.findViewById(f.g.left_member);
                cVar3.diD = (BawuMemberInfoView) view.findViewById(f.g.right_member);
                cVar3.diE = (BawuManagerApplyInfoView) view.findViewById(f.g.left_manager_apply);
                cVar3.diF = (BawuManagerApplyInfoView) view.findViewById(f.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.asR() != null && bVar.asR().size() > 0) {
                if (bVar.isLast()) {
                    cVar.diB.setPadding(this.cco, 0, this.cco, this.diz);
                    if (this.diy != null && !this.diy.isEmpty()) {
                        if (bVar.asR().size() == 2) {
                            if (bVar.asS().equals(this.mContext.getResources().getString(f.j.bawu_member_bazhu_tip))) {
                                cVar.diF.setVisibility(8);
                                cVar.diE.setVisibility(0);
                                cVar.diE.R(this.mContext.getResources().getString(f.j.tip_manager_apply), this.diy.atd());
                                cVar.diE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.div != null) {
                                            h.this.div.mk(h.this.diy.atg());
                                        }
                                    }
                                });
                            } else if (bVar.asS().equals(this.mContext.getResources().getString(f.j.bawu_member_xbazhu_tip))) {
                                cVar.diF.setVisibility(8);
                                cVar.diE.setVisibility(0);
                                cVar.diE.R(this.mContext.getResources().getString(f.j.tip_assist_apply), this.diy.atf());
                                cVar.diE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.div != null) {
                                            h.this.div.mk(h.this.diy.ath());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.asS().equals(this.mContext.getResources().getString(f.j.bawu_member_bazhu_tip))) {
                            cVar.diD.setVisibility(8);
                            cVar.diF.setVisibility(0);
                            cVar.diE.setVisibility(8);
                            cVar.diF.R(this.mContext.getResources().getString(f.j.tip_manager_apply), this.diy.atd());
                            cVar.diF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.div != null) {
                                        h.this.div.mk(h.this.diy.atg());
                                    }
                                }
                            });
                        } else if (bVar.asS().equals(this.mContext.getResources().getString(f.j.bawu_member_xbazhu_tip))) {
                            cVar.diD.setVisibility(8);
                            cVar.diF.setVisibility(0);
                            cVar.diE.setVisibility(8);
                            cVar.diF.R(this.mContext.getResources().getString(f.j.tip_assist_apply), this.diy.atf());
                            cVar.diF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.div != null) {
                                        h.this.div.mk(h.this.diy.ath());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.diB.setPadding(this.cco, 0, this.cco, 0);
                    cVar.diE.setVisibility(8);
                    cVar.diF.setVisibility(8);
                }
                cVar.diC.a(bVar.asR().get(0));
                if (bVar.asR().size() >= 2) {
                    cVar.diD.a(bVar.asR().get(1));
                    cVar.diD.setVisibility(0);
                } else {
                    cVar.diD.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cUL = view.findViewById(f.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void N(ArrayList<i> arrayList) {
        this.dix = arrayList;
    }

    public void a(p pVar) {
        this.diy = pVar;
    }

    public void a(b bVar) {
        this.div = bVar;
    }

    /* loaded from: classes3.dex */
    public class c {
        RelativeLayout diB;
        BawuMemberInfoView diC;
        BawuMemberInfoView diD;
        BawuManagerApplyInfoView diE;
        BawuManagerApplyInfoView diF;

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
        View cUL;

        public a() {
        }
    }
}
