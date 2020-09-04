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
    private TbPageContext<?> efr;
    private ArrayList<i> hOB = new ArrayList<>();
    private p hOC;
    private int hOD;
    private int hOE;
    private b hOz;

    /* loaded from: classes17.dex */
    public interface b {
        void Ih(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.hOD = 0;
        this.hOE = 0;
        this.efr = tbPageContext;
        this.hOD = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.hOE = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hOB != null) {
            return this.hOB.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wC */
    public i getItem(int i) {
        if (this.hOB == null || i >= this.hOB.size()) {
            return null;
        }
        return this.hOB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).ckd();
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
                view = LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.efr.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.hOG.setVisibility(0);
                cVar2.hOH.setVisibility(8);
                cVar2.hOI.setVisibility(8);
                cVar2.hOJ.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.hOG = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.hOH = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.hOI = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.hOJ = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.cke() != null && bVar.cke().size() > 0) {
                if (bVar.isLast() && bVar.ckf()) {
                    cVar.mRoot.setPadding(this.hOD, 0, this.hOD, this.hOE);
                    if (this.hOC != null && !this.hOC.isEmpty()) {
                        if (bVar.cke().size() == 2) {
                            if (bVar.ckg().equals(this.efr.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.hOJ.setVisibility(8);
                                cVar.hOI.setVisibility(8);
                            } else if (bVar.ckg().equals(this.efr.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.hOJ.setVisibility(8);
                                cVar.hOI.setVisibility(0);
                                cVar.hOI.aK(this.efr.getResources().getString(R.string.tip_assist_apply), this.hOC.ckp());
                                cVar.hOI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.hOz != null) {
                                            h.this.hOz.Ih(h.this.hOC.ckq());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.ckg().equals(this.efr.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.hOH.setVisibility(8);
                            cVar.hOJ.setVisibility(8);
                            cVar.hOI.setVisibility(8);
                        } else if (bVar.ckg().equals(this.efr.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.hOH.setVisibility(8);
                            cVar.hOJ.setVisibility(0);
                            cVar.hOI.setVisibility(8);
                            cVar.hOJ.aK(this.efr.getResources().getString(R.string.tip_assist_apply), this.hOC.ckp());
                            cVar.hOJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.hOz != null) {
                                        h.this.hOz.Ih(h.this.hOC.ckq());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.hOD, 0, this.hOD, 0);
                    cVar.hOI.setVisibility(8);
                    cVar.hOJ.setVisibility(8);
                }
                cVar.hOG.a(bVar.cke().get(0));
                if (bVar.cke().size() >= 2) {
                    cVar.hOH.a(bVar.cke().get(1));
                    cVar.hOH.setVisibility(0);
                } else {
                    cVar.hOH.setVisibility(8);
                }
                this.efr.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.dDB = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.efr.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void at(ArrayList<i> arrayList) {
        this.hOB = arrayList;
    }

    public void a(p pVar) {
        this.hOC = pVar;
    }

    public void a(b bVar) {
        this.hOz = bVar;
    }

    /* loaded from: classes17.dex */
    public class c {
        BawuMemberInfoView hOG;
        BawuMemberInfoView hOH;
        BawuManagerApplyInfoView hOI;
        BawuManagerApplyInfoView hOJ;
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
        View dDB;

        public a() {
        }
    }
}
