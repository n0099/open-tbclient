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
    private TbPageContext<?> duK;
    private b gUn;
    private ArrayList<i> gUp = new ArrayList<>();
    private p gUq;
    private int gUr;
    private int gUs;

    /* loaded from: classes10.dex */
    public interface b {
        void CK(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.gUr = 0;
        this.gUs = 0;
        this.duK = tbPageContext;
        this.gUr = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.gUs = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gUp != null) {
            return this.gUp.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sN */
    public i getItem(int i) {
        if (this.gUp == null || i >= this.gUp.size()) {
            return null;
        }
        return this.gUp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bMS();
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
                view = LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.duK.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.gUu.setVisibility(0);
                cVar2.gUv.setVisibility(8);
                cVar2.gUw.setVisibility(8);
                cVar2.gUx.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.gUu = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.gUv = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.gUw = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.gUx = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bMT() != null && bVar.bMT().size() > 0) {
                if (bVar.isLast() && bVar.bMU()) {
                    cVar.mRoot.setPadding(this.gUr, 0, this.gUr, this.gUs);
                    if (this.gUq != null && !this.gUq.isEmpty()) {
                        if (bVar.bMT().size() == 2) {
                            if (bVar.bMV().equals(this.duK.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.gUx.setVisibility(8);
                                cVar.gUw.setVisibility(8);
                            } else if (bVar.bMV().equals(this.duK.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.gUx.setVisibility(8);
                                cVar.gUw.setVisibility(0);
                                cVar.gUw.aI(this.duK.getResources().getString(R.string.tip_assist_apply), this.gUq.bNe());
                                cVar.gUw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.gUn != null) {
                                            h.this.gUn.CK(h.this.gUq.bNf());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bMV().equals(this.duK.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.gUv.setVisibility(8);
                            cVar.gUx.setVisibility(8);
                            cVar.gUw.setVisibility(8);
                        } else if (bVar.bMV().equals(this.duK.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.gUv.setVisibility(8);
                            cVar.gUx.setVisibility(0);
                            cVar.gUw.setVisibility(8);
                            cVar.gUx.aI(this.duK.getResources().getString(R.string.tip_assist_apply), this.gUq.bNe());
                            cVar.gUx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.gUn != null) {
                                        h.this.gUn.CK(h.this.gUq.bNf());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.gUr, 0, this.gUr, 0);
                    cVar.gUw.setVisibility(8);
                    cVar.gUx.setVisibility(8);
                }
                cVar.gUu.a(bVar.bMT().get(0));
                if (bVar.bMT().size() >= 2) {
                    cVar.gUv.a(bVar.bMT().get(1));
                    cVar.gUv.setVisibility(0);
                } else {
                    cVar.gUv.setVisibility(8);
                }
                this.duK.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cXO = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.duK.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void am(ArrayList<i> arrayList) {
        this.gUp = arrayList;
    }

    public void a(p pVar) {
        this.gUq = pVar;
    }

    public void a(b bVar) {
        this.gUn = bVar;
    }

    /* loaded from: classes10.dex */
    public class c {
        BawuMemberInfoView gUu;
        BawuMemberInfoView gUv;
        BawuManagerApplyInfoView gUw;
        BawuManagerApplyInfoView gUx;
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
        View cXO;

        public a() {
        }
    }
}
