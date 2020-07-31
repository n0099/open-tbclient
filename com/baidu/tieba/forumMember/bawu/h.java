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
/* loaded from: classes17.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> dVN;
    private b hBe;
    private ArrayList<i> hBg = new ArrayList<>();
    private p hBh;
    private int hBi;
    private int hBj;

    /* loaded from: classes17.dex */
    public interface b {
        void FF(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.hBi = 0;
        this.hBj = 0;
        this.dVN = tbPageContext;
        this.hBi = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.hBj = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hBg != null) {
            return this.hBg.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: un */
    public i getItem(int i) {
        if (this.hBg == null || i >= this.hBg.size()) {
            return null;
        }
        return this.hBg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bZG();
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
                view = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.dVN.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.hBl.setVisibility(0);
                cVar2.hBm.setVisibility(8);
                cVar2.hBn.setVisibility(8);
                cVar2.hBo.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.hBl = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.hBm = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.hBn = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.hBo = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bZH() != null && bVar.bZH().size() > 0) {
                if (bVar.isLast() && bVar.bZI()) {
                    cVar.mRoot.setPadding(this.hBi, 0, this.hBi, this.hBj);
                    if (this.hBh != null && !this.hBh.isEmpty()) {
                        if (bVar.bZH().size() == 2) {
                            if (bVar.bZJ().equals(this.dVN.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.hBo.setVisibility(8);
                                cVar.hBn.setVisibility(8);
                            } else if (bVar.bZJ().equals(this.dVN.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.hBo.setVisibility(8);
                                cVar.hBn.setVisibility(0);
                                cVar.hBn.aH(this.dVN.getResources().getString(R.string.tip_assist_apply), this.hBh.bZS());
                                cVar.hBn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.hBe != null) {
                                            h.this.hBe.FF(h.this.hBh.bZT());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bZJ().equals(this.dVN.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.hBm.setVisibility(8);
                            cVar.hBo.setVisibility(8);
                            cVar.hBn.setVisibility(8);
                        } else if (bVar.bZJ().equals(this.dVN.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.hBm.setVisibility(8);
                            cVar.hBo.setVisibility(0);
                            cVar.hBn.setVisibility(8);
                            cVar.hBo.aH(this.dVN.getResources().getString(R.string.tip_assist_apply), this.hBh.bZS());
                            cVar.hBo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.hBe != null) {
                                        h.this.hBe.FF(h.this.hBh.bZT());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.hBi, 0, this.hBi, 0);
                    cVar.hBn.setVisibility(8);
                    cVar.hBo.setVisibility(8);
                }
                cVar.hBl.a(bVar.bZH().get(0));
                if (bVar.bZH().size() >= 2) {
                    cVar.hBm.a(bVar.bZH().get(1));
                    cVar.hBm.setVisibility(0);
                } else {
                    cVar.hBm.setVisibility(8);
                }
                this.dVN.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.dty = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.dVN.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void an(ArrayList<i> arrayList) {
        this.hBg = arrayList;
    }

    public void a(p pVar) {
        this.hBh = pVar;
    }

    public void a(b bVar) {
        this.hBe = bVar;
    }

    /* loaded from: classes17.dex */
    public class c {
        BawuMemberInfoView hBl;
        BawuMemberInfoView hBm;
        BawuManagerApplyInfoView hBn;
        BawuManagerApplyInfoView hBo;
        RelativeLayout mRoot;

        public c() {
        }
    }

    /* loaded from: classes17.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes17.dex */
    public class a {
        View dty;

        public a() {
        }
    }
}
