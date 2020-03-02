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
    private TbPageContext<?> cVh;
    private b gkf;
    private ArrayList<i> gkh = new ArrayList<>();
    private p gki;
    private int gkj;
    private int gkk;

    /* loaded from: classes10.dex */
    public interface b {
        void AU(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.gkj = 0;
        this.gkk = 0;
        this.cVh = tbPageContext;
        this.gkj = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.gkk = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gkh != null) {
            return this.gkh.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: so */
    public i getItem(int i) {
        if (this.gkh == null || i >= this.gkh.size()) {
            return null;
        }
        return this.gkh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bCn();
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
                view = LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.cVh.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.gkm.setVisibility(0);
                cVar2.gkn.setVisibility(8);
                cVar2.gko.setVisibility(8);
                cVar2.gkp.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.gkm = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.gkn = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.gko = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.gkp = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bCo() != null && bVar.bCo().size() > 0) {
                if (bVar.isLast() && bVar.bCp()) {
                    cVar.mRoot.setPadding(this.gkj, 0, this.gkj, this.gkk);
                    if (this.gki != null && !this.gki.isEmpty()) {
                        if (bVar.bCo().size() == 2) {
                            if (bVar.bCq().equals(this.cVh.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.gkp.setVisibility(8);
                                cVar.gko.setVisibility(8);
                            } else if (bVar.bCq().equals(this.cVh.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.gkp.setVisibility(8);
                                cVar.gko.setVisibility(0);
                                cVar.gko.ay(this.cVh.getResources().getString(R.string.tip_assist_apply), this.gki.bCz());
                                cVar.gko.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.gkf != null) {
                                            h.this.gkf.AU(h.this.gki.bCA());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bCq().equals(this.cVh.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.gkn.setVisibility(8);
                            cVar.gkp.setVisibility(8);
                            cVar.gko.setVisibility(8);
                        } else if (bVar.bCq().equals(this.cVh.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.gkn.setVisibility(8);
                            cVar.gkp.setVisibility(0);
                            cVar.gko.setVisibility(8);
                            cVar.gkp.ay(this.cVh.getResources().getString(R.string.tip_assist_apply), this.gki.bCz());
                            cVar.gkp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.gkf != null) {
                                        h.this.gkf.AU(h.this.gki.bCA());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.gkj, 0, this.gkj, 0);
                    cVar.gko.setVisibility(8);
                    cVar.gkp.setVisibility(8);
                }
                cVar.gkm.a(bVar.bCo().get(0));
                if (bVar.bCo().size() >= 2) {
                    cVar.gkn.a(bVar.bCo().get(1));
                    cVar.gkn.setVisibility(0);
                } else {
                    cVar.gkn.setVisibility(8);
                }
                this.cVh.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cyA = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.cVh.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void ak(ArrayList<i> arrayList) {
        this.gkh = arrayList;
    }

    public void a(p pVar) {
        this.gki = pVar;
    }

    public void a(b bVar) {
        this.gkf = bVar;
    }

    /* loaded from: classes10.dex */
    public class c {
        BawuMemberInfoView gkm;
        BawuMemberInfoView gkn;
        BawuManagerApplyInfoView gko;
        BawuManagerApplyInfoView gkp;
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
        View cyA;

        public a() {
        }
    }
}
