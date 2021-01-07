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
    private TbPageContext<?> eXu;
    private int eYU;
    private b jaN;
    private ArrayList<i> jaP = new ArrayList<>();
    private l jaQ;
    private int jaR;

    /* loaded from: classes8.dex */
    public interface b {
        void Kv(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.eYU = 0;
        this.jaR = 0;
        this.eXu = tbPageContext;
        this.eYU = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.jaR = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jaP != null) {
            return this.jaP.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zD */
    public i getItem(int i) {
        if (this.jaP == null || i >= this.jaP.size()) {
            return null;
        }
        return this.jaP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).cDj();
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
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.eXu.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.jaU.setVisibility(0);
                cVar2.jaV.setVisibility(8);
                cVar2.jaW.setVisibility(8);
                cVar2.jaX.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.jaT = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.jaU = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.jaV = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.jaW = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.jaX = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.cDk() != null && bVar.cDk().size() > 0) {
                if (bVar.isLast() && bVar.cDl()) {
                    cVar.jaT.setPadding(this.eYU, 0, this.eYU, this.jaR);
                    if (this.jaQ != null && !this.jaQ.isEmpty()) {
                        if (bVar.cDk().size() == 2) {
                            if (bVar.cDm().equals(this.eXu.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.jaX.setVisibility(8);
                                cVar.jaW.setVisibility(8);
                            } else if (bVar.cDm().equals(this.eXu.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.jaX.setVisibility(8);
                                cVar.jaW.setVisibility(0);
                                cVar.jaW.aW(this.eXu.getResources().getString(R.string.tip_assist_apply), this.jaQ.cDv());
                                cVar.jaW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.jaN != null) {
                                            h.this.jaN.Kv(h.this.jaQ.cDw());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.cDm().equals(this.eXu.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.jaV.setVisibility(8);
                            cVar.jaX.setVisibility(8);
                            cVar.jaW.setVisibility(8);
                        } else if (bVar.cDm().equals(this.eXu.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.jaV.setVisibility(8);
                            cVar.jaX.setVisibility(0);
                            cVar.jaW.setVisibility(8);
                            cVar.jaX.aW(this.eXu.getResources().getString(R.string.tip_assist_apply), this.jaQ.cDv());
                            cVar.jaX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.jaN != null) {
                                        h.this.jaN.Kv(h.this.jaQ.cDw());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.jaT.setPadding(this.eYU, 0, this.eYU, 0);
                    cVar.jaW.setVisibility(8);
                    cVar.jaX.setVisibility(8);
                }
                cVar.jaU.a(bVar.cDk().get(0));
                if (bVar.cDk().size() >= 2) {
                    cVar.jaV.a(bVar.cDk().get(1));
                    cVar.jaV.setVisibility(0);
                } else {
                    cVar.jaV.setVisibility(8);
                }
                this.eXu.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.eup = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.eXu.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void ay(ArrayList<i> arrayList) {
        this.jaP = arrayList;
    }

    public void a(l lVar) {
        this.jaQ = lVar;
    }

    public void a(b bVar) {
        this.jaN = bVar;
    }

    /* loaded from: classes8.dex */
    public class c {
        RelativeLayout jaT;
        BawuMemberInfoView jaU;
        BawuMemberInfoView jaV;
        BawuManagerApplyInfoView jaW;
        BawuManagerApplyInfoView jaX;

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
        View eup;

        public a() {
        }
    }
}
