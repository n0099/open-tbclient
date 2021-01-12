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
/* loaded from: classes7.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> eSJ;
    private int eUj;
    private b iWg;
    private ArrayList<i> iWi = new ArrayList<>();
    private l iWj;
    private int iWk;

    /* loaded from: classes7.dex */
    public interface b {
        void Jk(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.eUj = 0;
        this.iWk = 0;
        this.eSJ = tbPageContext;
        this.eUj = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.iWk = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iWi != null) {
            return this.iWi.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xX */
    public i getItem(int i) {
        if (this.iWi == null || i >= this.iWi.size()) {
            return null;
        }
        return this.iWi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).czr();
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
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.eSJ.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.iWn.setVisibility(0);
                cVar2.iWo.setVisibility(8);
                cVar2.iWp.setVisibility(8);
                cVar2.iWq.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.iWm = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.iWn = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.iWo = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.iWp = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.iWq = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.czs() != null && bVar.czs().size() > 0) {
                if (bVar.isLast() && bVar.czt()) {
                    cVar.iWm.setPadding(this.eUj, 0, this.eUj, this.iWk);
                    if (this.iWj != null && !this.iWj.isEmpty()) {
                        if (bVar.czs().size() == 2) {
                            if (bVar.czu().equals(this.eSJ.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.iWq.setVisibility(8);
                                cVar.iWp.setVisibility(8);
                            } else if (bVar.czu().equals(this.eSJ.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.iWq.setVisibility(8);
                                cVar.iWp.setVisibility(0);
                                cVar.iWp.aW(this.eSJ.getResources().getString(R.string.tip_assist_apply), this.iWj.czD());
                                cVar.iWp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.iWg != null) {
                                            h.this.iWg.Jk(h.this.iWj.czE());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.czu().equals(this.eSJ.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.iWo.setVisibility(8);
                            cVar.iWq.setVisibility(8);
                            cVar.iWp.setVisibility(8);
                        } else if (bVar.czu().equals(this.eSJ.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.iWo.setVisibility(8);
                            cVar.iWq.setVisibility(0);
                            cVar.iWp.setVisibility(8);
                            cVar.iWq.aW(this.eSJ.getResources().getString(R.string.tip_assist_apply), this.iWj.czD());
                            cVar.iWq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.iWg != null) {
                                        h.this.iWg.Jk(h.this.iWj.czE());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.iWm.setPadding(this.eUj, 0, this.eUj, 0);
                    cVar.iWp.setVisibility(8);
                    cVar.iWq.setVisibility(8);
                }
                cVar.iWn.a(bVar.czs().get(0));
                if (bVar.czs().size() >= 2) {
                    cVar.iWo.a(bVar.czs().get(1));
                    cVar.iWo.setVisibility(0);
                } else {
                    cVar.iWo.setVisibility(8);
                }
                this.eSJ.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.epB = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.eSJ.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void at(ArrayList<i> arrayList) {
        this.iWi = arrayList;
    }

    public void a(l lVar) {
        this.iWj = lVar;
    }

    public void a(b bVar) {
        this.iWg = bVar;
    }

    /* loaded from: classes7.dex */
    public class c {
        RelativeLayout iWm;
        BawuMemberInfoView iWn;
        BawuMemberInfoView iWo;
        BawuManagerApplyInfoView iWp;
        BawuManagerApplyInfoView iWq;

        public c() {
        }
    }

    /* loaded from: classes7.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes7.dex */
    public class a {
        View epB;

        public a() {
        }
    }
}
