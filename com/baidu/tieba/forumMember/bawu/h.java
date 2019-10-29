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
/* loaded from: classes5.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> cfl;
    private b frm;
    private ArrayList<i> fro = new ArrayList<>();
    private p frp;
    private int frq;
    private int frr;

    /* loaded from: classes5.dex */
    public interface b {
        void vC(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.frq = 0;
        this.frr = 0;
        this.cfl = tbPageContext;
        this.frq = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.frr = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fro != null) {
            return this.fro.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pY */
    public i getItem(int i) {
        if (this.fro == null || i >= this.fro.size()) {
            return null;
        }
        return this.fro.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bio();
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
                view = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.cfl.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.frv.setVisibility(0);
                cVar2.frw.setVisibility(8);
                cVar2.frx.setVisibility(8);
                cVar2.fry.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.fru = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.frv = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.frw = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.frx = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.fry = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bip() != null && bVar.bip().size() > 0) {
                if (bVar.isLast() && bVar.biq()) {
                    cVar.fru.setPadding(this.frq, 0, this.frq, this.frr);
                    if (this.frp != null && !this.frp.isEmpty()) {
                        if (bVar.bip().size() == 2) {
                            if (bVar.bir().equals(this.cfl.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.fry.setVisibility(8);
                                cVar.frx.setVisibility(8);
                            } else if (bVar.bir().equals(this.cfl.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.fry.setVisibility(8);
                                cVar.frx.setVisibility(0);
                                cVar.frx.aq(this.cfl.getResources().getString(R.string.tip_assist_apply), this.frp.biA());
                                cVar.frx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.frm != null) {
                                            h.this.frm.vC(h.this.frp.biB());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bir().equals(this.cfl.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.frw.setVisibility(8);
                            cVar.fry.setVisibility(8);
                            cVar.frx.setVisibility(8);
                        } else if (bVar.bir().equals(this.cfl.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.frw.setVisibility(8);
                            cVar.fry.setVisibility(0);
                            cVar.frx.setVisibility(8);
                            cVar.fry.aq(this.cfl.getResources().getString(R.string.tip_assist_apply), this.frp.biA());
                            cVar.fry.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.frm != null) {
                                        h.this.frm.vC(h.this.frp.biB());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.fru.setPadding(this.frq, 0, this.frq, 0);
                    cVar.frx.setVisibility(8);
                    cVar.fry.setVisibility(8);
                }
                cVar.frv.a(bVar.bip().get(0));
                if (bVar.bip().size() >= 2) {
                    cVar.frw.a(bVar.bip().get(1));
                    cVar.frw.setVisibility(0);
                } else {
                    cVar.frw.setVisibility(8);
                }
                this.cfl.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.bJN = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.cfl.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void Z(ArrayList<i> arrayList) {
        this.fro = arrayList;
    }

    public void a(p pVar) {
        this.frp = pVar;
    }

    public void a(b bVar) {
        this.frm = bVar;
    }

    /* loaded from: classes5.dex */
    public class c {
        RelativeLayout fru;
        BawuMemberInfoView frv;
        BawuMemberInfoView frw;
        BawuManagerApplyInfoView frx;
        BawuManagerApplyInfoView fry;

        public c() {
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes5.dex */
    public class a {
        View bJN;

        public a() {
        }
    }
}
