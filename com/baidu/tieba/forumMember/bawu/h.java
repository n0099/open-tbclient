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
    private TbPageContext<?> cVi;
    private b gks;
    private ArrayList<i> gku = new ArrayList<>();
    private p gkv;
    private int gkw;
    private int gkx;

    /* loaded from: classes10.dex */
    public interface b {
        void AV(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.gkw = 0;
        this.gkx = 0;
        this.cVi = tbPageContext;
        this.gkw = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.gkx = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gku != null) {
            return this.gku.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: so */
    public i getItem(int i) {
        if (this.gku == null || i >= this.gku.size()) {
            return null;
        }
        return this.gku.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bCo();
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
                view = LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.cVi.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.gkz.setVisibility(0);
                cVar2.gkA.setVisibility(8);
                cVar2.gkB.setVisibility(8);
                cVar2.gkC.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.gkz = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.gkA = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.gkB = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.gkC = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bCp() != null && bVar.bCp().size() > 0) {
                if (bVar.isLast() && bVar.bCq()) {
                    cVar.mRoot.setPadding(this.gkw, 0, this.gkw, this.gkx);
                    if (this.gkv != null && !this.gkv.isEmpty()) {
                        if (bVar.bCp().size() == 2) {
                            if (bVar.bCr().equals(this.cVi.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.gkC.setVisibility(8);
                                cVar.gkB.setVisibility(8);
                            } else if (bVar.bCr().equals(this.cVi.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.gkC.setVisibility(8);
                                cVar.gkB.setVisibility(0);
                                cVar.gkB.ay(this.cVi.getResources().getString(R.string.tip_assist_apply), this.gkv.bCA());
                                cVar.gkB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.gks != null) {
                                            h.this.gks.AV(h.this.gkv.bCB());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bCr().equals(this.cVi.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.gkA.setVisibility(8);
                            cVar.gkC.setVisibility(8);
                            cVar.gkB.setVisibility(8);
                        } else if (bVar.bCr().equals(this.cVi.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.gkA.setVisibility(8);
                            cVar.gkC.setVisibility(0);
                            cVar.gkB.setVisibility(8);
                            cVar.gkC.ay(this.cVi.getResources().getString(R.string.tip_assist_apply), this.gkv.bCA());
                            cVar.gkC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.gks != null) {
                                        h.this.gks.AV(h.this.gkv.bCB());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.gkw, 0, this.gkw, 0);
                    cVar.gkB.setVisibility(8);
                    cVar.gkC.setVisibility(8);
                }
                cVar.gkz.a(bVar.bCp().get(0));
                if (bVar.bCp().size() >= 2) {
                    cVar.gkA.a(bVar.bCp().get(1));
                    cVar.gkA.setVisibility(0);
                } else {
                    cVar.gkA.setVisibility(8);
                }
                this.cVi.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cyB = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.cVi.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void ak(ArrayList<i> arrayList) {
        this.gku = arrayList;
    }

    public void a(p pVar) {
        this.gkv = pVar;
    }

    public void a(b bVar) {
        this.gks = bVar;
    }

    /* loaded from: classes10.dex */
    public class c {
        BawuMemberInfoView gkA;
        BawuManagerApplyInfoView gkB;
        BawuManagerApplyInfoView gkC;
        BawuMemberInfoView gkz;
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
        View cyB;

        public a() {
        }
    }
}
