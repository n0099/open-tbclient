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
/* loaded from: classes10.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> dPv;
    private b hvs;
    private ArrayList<i> hvu = new ArrayList<>();
    private p hvv;
    private int hvw;
    private int hvx;

    /* loaded from: classes10.dex */
    public interface b {
        void EU(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.hvw = 0;
        this.hvx = 0;
        this.dPv = tbPageContext;
        this.hvw = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.hvx = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hvu != null) {
            return this.hvu.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tV */
    public i getItem(int i) {
        if (this.hvu == null || i >= this.hvu.size()) {
            return null;
        }
        return this.hvu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bWn();
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
                view = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.dPv.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.hvz.setVisibility(0);
                cVar2.hvA.setVisibility(8);
                cVar2.hvB.setVisibility(8);
                cVar2.hvC.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.hvz = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.hvA = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.hvB = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.hvC = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bWo() != null && bVar.bWo().size() > 0) {
                if (bVar.isLast() && bVar.bWp()) {
                    cVar.mRoot.setPadding(this.hvw, 0, this.hvw, this.hvx);
                    if (this.hvv != null && !this.hvv.isEmpty()) {
                        if (bVar.bWo().size() == 2) {
                            if (bVar.bWq().equals(this.dPv.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.hvC.setVisibility(8);
                                cVar.hvB.setVisibility(8);
                            } else if (bVar.bWq().equals(this.dPv.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.hvC.setVisibility(8);
                                cVar.hvB.setVisibility(0);
                                cVar.hvB.aI(this.dPv.getResources().getString(R.string.tip_assist_apply), this.hvv.bWz());
                                cVar.hvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.hvs != null) {
                                            h.this.hvs.EU(h.this.hvv.bWA());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bWq().equals(this.dPv.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.hvA.setVisibility(8);
                            cVar.hvC.setVisibility(8);
                            cVar.hvB.setVisibility(8);
                        } else if (bVar.bWq().equals(this.dPv.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.hvA.setVisibility(8);
                            cVar.hvC.setVisibility(0);
                            cVar.hvB.setVisibility(8);
                            cVar.hvC.aI(this.dPv.getResources().getString(R.string.tip_assist_apply), this.hvv.bWz());
                            cVar.hvC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.hvs != null) {
                                        h.this.hvs.EU(h.this.hvv.bWA());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.hvw, 0, this.hvw, 0);
                    cVar.hvB.setVisibility(8);
                    cVar.hvC.setVisibility(8);
                }
                cVar.hvz.a(bVar.bWo().get(0));
                if (bVar.bWo().size() >= 2) {
                    cVar.hvA.a(bVar.bWo().get(1));
                    cVar.hvA.setVisibility(0);
                } else {
                    cVar.hvA.setVisibility(8);
                }
                this.dPv.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.dnC = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.dPv.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void am(ArrayList<i> arrayList) {
        this.hvu = arrayList;
    }

    public void a(p pVar) {
        this.hvv = pVar;
    }

    public void a(b bVar) {
        this.hvs = bVar;
    }

    /* loaded from: classes10.dex */
    public class c {
        BawuMemberInfoView hvA;
        BawuManagerApplyInfoView hvB;
        BawuManagerApplyInfoView hvC;
        BawuMemberInfoView hvz;
        RelativeLayout mRoot;

        public c() {
        }
    }

    /* loaded from: classes10.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        View dnC;

        public a() {
        }
    }
}
