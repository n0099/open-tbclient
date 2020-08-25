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
    private TbPageContext<?> efn;
    private b hOt;
    private ArrayList<i> hOv = new ArrayList<>();
    private p hOw;
    private int hOx;
    private int hOy;

    /* loaded from: classes17.dex */
    public interface b {
        void Ig(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.hOx = 0;
        this.hOy = 0;
        this.efn = tbPageContext;
        this.hOx = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.hOy = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hOv != null) {
            return this.hOv.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wC */
    public i getItem(int i) {
        if (this.hOv == null || i >= this.hOv.size()) {
            return null;
        }
        return this.hOv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).ckc();
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
                view = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.efn.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.hOA.setVisibility(0);
                cVar2.hOB.setVisibility(8);
                cVar2.hOC.setVisibility(8);
                cVar2.hOD.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.hOA = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.hOB = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.hOC = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.hOD = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.ckd() != null && bVar.ckd().size() > 0) {
                if (bVar.isLast() && bVar.cke()) {
                    cVar.mRoot.setPadding(this.hOx, 0, this.hOx, this.hOy);
                    if (this.hOw != null && !this.hOw.isEmpty()) {
                        if (bVar.ckd().size() == 2) {
                            if (bVar.ckf().equals(this.efn.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.hOD.setVisibility(8);
                                cVar.hOC.setVisibility(8);
                            } else if (bVar.ckf().equals(this.efn.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.hOD.setVisibility(8);
                                cVar.hOC.setVisibility(0);
                                cVar.hOC.aK(this.efn.getResources().getString(R.string.tip_assist_apply), this.hOw.cko());
                                cVar.hOC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.hOt != null) {
                                            h.this.hOt.Ig(h.this.hOw.ckp());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.ckf().equals(this.efn.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.hOB.setVisibility(8);
                            cVar.hOD.setVisibility(8);
                            cVar.hOC.setVisibility(8);
                        } else if (bVar.ckf().equals(this.efn.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.hOB.setVisibility(8);
                            cVar.hOD.setVisibility(0);
                            cVar.hOC.setVisibility(8);
                            cVar.hOD.aK(this.efn.getResources().getString(R.string.tip_assist_apply), this.hOw.cko());
                            cVar.hOD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.hOt != null) {
                                        h.this.hOt.Ig(h.this.hOw.ckp());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.hOx, 0, this.hOx, 0);
                    cVar.hOC.setVisibility(8);
                    cVar.hOD.setVisibility(8);
                }
                cVar.hOA.a(bVar.ckd().get(0));
                if (bVar.ckd().size() >= 2) {
                    cVar.hOB.a(bVar.ckd().get(1));
                    cVar.hOB.setVisibility(0);
                } else {
                    cVar.hOB.setVisibility(8);
                }
                this.efn.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.dDx = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.efn.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void at(ArrayList<i> arrayList) {
        this.hOv = arrayList;
    }

    public void a(p pVar) {
        this.hOw = pVar;
    }

    public void a(b bVar) {
        this.hOt = bVar;
    }

    /* loaded from: classes17.dex */
    public class c {
        BawuMemberInfoView hOA;
        BawuMemberInfoView hOB;
        BawuManagerApplyInfoView hOC;
        BawuManagerApplyInfoView hOD;
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
        View dDx;

        public a() {
        }
    }
}
