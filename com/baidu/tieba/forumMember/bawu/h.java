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
    private TbPageContext<?> cVg;
    private b gkd;
    private ArrayList<i> gkf = new ArrayList<>();
    private p gkg;
    private int gkh;
    private int gki;

    /* loaded from: classes10.dex */
    public interface b {
        void AU(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.gkh = 0;
        this.gki = 0;
        this.cVg = tbPageContext;
        this.gkh = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.gki = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gkf != null) {
            return this.gkf.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: so */
    public i getItem(int i) {
        if (this.gkf == null || i >= this.gkf.size()) {
            return null;
        }
        return this.gkf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bCl();
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
                view = LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.cVg.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.gkk.setVisibility(0);
                cVar2.gkl.setVisibility(8);
                cVar2.gkm.setVisibility(8);
                cVar2.gkn.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.gkk = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.gkl = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.gkm = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.gkn = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bCm() != null && bVar.bCm().size() > 0) {
                if (bVar.isLast() && bVar.bCn()) {
                    cVar.mRoot.setPadding(this.gkh, 0, this.gkh, this.gki);
                    if (this.gkg != null && !this.gkg.isEmpty()) {
                        if (bVar.bCm().size() == 2) {
                            if (bVar.bCo().equals(this.cVg.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.gkn.setVisibility(8);
                                cVar.gkm.setVisibility(8);
                            } else if (bVar.bCo().equals(this.cVg.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.gkn.setVisibility(8);
                                cVar.gkm.setVisibility(0);
                                cVar.gkm.ay(this.cVg.getResources().getString(R.string.tip_assist_apply), this.gkg.bCx());
                                cVar.gkm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.gkd != null) {
                                            h.this.gkd.AU(h.this.gkg.bCy());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bCo().equals(this.cVg.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.gkl.setVisibility(8);
                            cVar.gkn.setVisibility(8);
                            cVar.gkm.setVisibility(8);
                        } else if (bVar.bCo().equals(this.cVg.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.gkl.setVisibility(8);
                            cVar.gkn.setVisibility(0);
                            cVar.gkm.setVisibility(8);
                            cVar.gkn.ay(this.cVg.getResources().getString(R.string.tip_assist_apply), this.gkg.bCx());
                            cVar.gkn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.gkd != null) {
                                        h.this.gkd.AU(h.this.gkg.bCy());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.gkh, 0, this.gkh, 0);
                    cVar.gkm.setVisibility(8);
                    cVar.gkn.setVisibility(8);
                }
                cVar.gkk.a(bVar.bCm().get(0));
                if (bVar.bCm().size() >= 2) {
                    cVar.gkl.a(bVar.bCm().get(1));
                    cVar.gkl.setVisibility(0);
                } else {
                    cVar.gkl.setVisibility(8);
                }
                this.cVg.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cyz = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.cVg.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void ak(ArrayList<i> arrayList) {
        this.gkf = arrayList;
    }

    public void a(p pVar) {
        this.gkg = pVar;
    }

    public void a(b bVar) {
        this.gkd = bVar;
    }

    /* loaded from: classes10.dex */
    public class c {
        BawuMemberInfoView gkk;
        BawuMemberInfoView gkl;
        BawuManagerApplyInfoView gkm;
        BawuManagerApplyInfoView gkn;
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
        View cyz;

        public a() {
        }
    }
}
