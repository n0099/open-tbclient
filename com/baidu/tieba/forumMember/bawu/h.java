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
    private TbPageContext<?> ceu;
    private int fqA;
    private b fqv;
    private ArrayList<i> fqx = new ArrayList<>();
    private p fqy;
    private int fqz;

    /* loaded from: classes5.dex */
    public interface b {
        void vC(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.fqz = 0;
        this.fqA = 0;
        this.ceu = tbPageContext;
        this.fqz = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.fqA = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqx != null) {
            return this.fqx.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pX */
    public i getItem(int i) {
        if (this.fqx == null || i >= this.fqx.size()) {
            return null;
        }
        return this.fqx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bim();
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
                view = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.ceu.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.fqD.setVisibility(0);
                cVar2.fqE.setVisibility(8);
                cVar2.fqF.setVisibility(8);
                cVar2.fqG.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.fqC = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.fqD = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.fqE = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.fqF = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.fqG = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bin() != null && bVar.bin().size() > 0) {
                if (bVar.isLast() && bVar.bio()) {
                    cVar.fqC.setPadding(this.fqz, 0, this.fqz, this.fqA);
                    if (this.fqy != null && !this.fqy.isEmpty()) {
                        if (bVar.bin().size() == 2) {
                            if (bVar.bip().equals(this.ceu.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.fqG.setVisibility(8);
                                cVar.fqF.setVisibility(8);
                            } else if (bVar.bip().equals(this.ceu.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.fqG.setVisibility(8);
                                cVar.fqF.setVisibility(0);
                                cVar.fqF.aq(this.ceu.getResources().getString(R.string.tip_assist_apply), this.fqy.biy());
                                cVar.fqF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.fqv != null) {
                                            h.this.fqv.vC(h.this.fqy.biz());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bip().equals(this.ceu.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.fqE.setVisibility(8);
                            cVar.fqG.setVisibility(8);
                            cVar.fqF.setVisibility(8);
                        } else if (bVar.bip().equals(this.ceu.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.fqE.setVisibility(8);
                            cVar.fqG.setVisibility(0);
                            cVar.fqF.setVisibility(8);
                            cVar.fqG.aq(this.ceu.getResources().getString(R.string.tip_assist_apply), this.fqy.biy());
                            cVar.fqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.fqv != null) {
                                        h.this.fqv.vC(h.this.fqy.biz());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.fqC.setPadding(this.fqz, 0, this.fqz, 0);
                    cVar.fqF.setVisibility(8);
                    cVar.fqG.setVisibility(8);
                }
                cVar.fqD.a(bVar.bin().get(0));
                if (bVar.bin().size() >= 2) {
                    cVar.fqE.a(bVar.bin().get(1));
                    cVar.fqE.setVisibility(0);
                } else {
                    cVar.fqE.setVisibility(8);
                }
                this.ceu.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.bIW = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.ceu.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void Z(ArrayList<i> arrayList) {
        this.fqx = arrayList;
    }

    public void a(p pVar) {
        this.fqy = pVar;
    }

    public void a(b bVar) {
        this.fqv = bVar;
    }

    /* loaded from: classes5.dex */
    public class c {
        RelativeLayout fqC;
        BawuMemberInfoView fqD;
        BawuMemberInfoView fqE;
        BawuManagerApplyInfoView fqF;
        BawuManagerApplyInfoView fqG;

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
        View bIW;

        public a() {
        }
    }
}
