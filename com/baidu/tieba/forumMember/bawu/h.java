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
    private TbPageContext<?> dIF;
    private b hiZ;
    private ArrayList<i> hjb = new ArrayList<>();
    private p hjc;
    private int hjd;
    private int hje;

    /* loaded from: classes10.dex */
    public interface b {
        void Et(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.hjd = 0;
        this.hje = 0;
        this.dIF = tbPageContext;
        this.hjd = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.hje = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hjb != null) {
            return this.hjb.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ts */
    public i getItem(int i) {
        if (this.hjb == null || i >= this.hjb.size()) {
            return null;
        }
        return this.hjb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bTo();
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
                view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.dIF.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.hjg.setVisibility(0);
                cVar2.hjh.setVisibility(8);
                cVar2.hji.setVisibility(8);
                cVar2.hjj.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.hjg = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.hjh = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.hji = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.hjj = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bTp() != null && bVar.bTp().size() > 0) {
                if (bVar.isLast() && bVar.bTq()) {
                    cVar.mRoot.setPadding(this.hjd, 0, this.hjd, this.hje);
                    if (this.hjc != null && !this.hjc.isEmpty()) {
                        if (bVar.bTp().size() == 2) {
                            if (bVar.bTr().equals(this.dIF.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.hjj.setVisibility(8);
                                cVar.hji.setVisibility(8);
                            } else if (bVar.bTr().equals(this.dIF.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.hjj.setVisibility(8);
                                cVar.hji.setVisibility(0);
                                cVar.hji.aJ(this.dIF.getResources().getString(R.string.tip_assist_apply), this.hjc.bTA());
                                cVar.hji.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.hiZ != null) {
                                            h.this.hiZ.Et(h.this.hjc.bTB());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bTr().equals(this.dIF.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.hjh.setVisibility(8);
                            cVar.hjj.setVisibility(8);
                            cVar.hji.setVisibility(8);
                        } else if (bVar.bTr().equals(this.dIF.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.hjh.setVisibility(8);
                            cVar.hjj.setVisibility(0);
                            cVar.hji.setVisibility(8);
                            cVar.hjj.aJ(this.dIF.getResources().getString(R.string.tip_assist_apply), this.hjc.bTA());
                            cVar.hjj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.hiZ != null) {
                                        h.this.hiZ.Et(h.this.hjc.bTB());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.hjd, 0, this.hjd, 0);
                    cVar.hji.setVisibility(8);
                    cVar.hjj.setVisibility(8);
                }
                cVar.hjg.a(bVar.bTp().get(0));
                if (bVar.bTp().size() >= 2) {
                    cVar.hjh.a(bVar.bTp().get(1));
                    cVar.hjh.setVisibility(0);
                } else {
                    cVar.hjh.setVisibility(8);
                }
                this.dIF.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.diS = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.dIF.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void am(ArrayList<i> arrayList) {
        this.hjb = arrayList;
    }

    public void a(p pVar) {
        this.hjc = pVar;
    }

    public void a(b bVar) {
        this.hiZ = bVar;
    }

    /* loaded from: classes10.dex */
    public class c {
        BawuMemberInfoView hjg;
        BawuMemberInfoView hjh;
        BawuManagerApplyInfoView hji;
        BawuManagerApplyInfoView hjj;
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
        View diS;

        public a() {
        }
    }
}
