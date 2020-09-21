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
/* loaded from: classes22.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> ehG;
    private ArrayList<i> hVB = new ArrayList<>();
    private p hVC;
    private int hVD;
    private int hVE;
    private b hVz;

    /* loaded from: classes22.dex */
    public interface b {
        void IE(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.hVD = 0;
        this.hVE = 0;
        this.ehG = tbPageContext;
        this.hVD = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.hVE = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hVB != null) {
            return this.hVB.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xb */
    public i getItem(int i) {
        if (this.hVB == null || i >= this.hVB.size()) {
            return null;
        }
        return this.hVB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).cnq();
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
                view = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.ehG.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.hVG.setVisibility(0);
                cVar2.hVH.setVisibility(8);
                cVar2.hVI.setVisibility(8);
                cVar2.hVJ.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.hVG = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.hVH = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.hVI = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.hVJ = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.cnr() != null && bVar.cnr().size() > 0) {
                if (bVar.isLast() && bVar.cns()) {
                    cVar.mRoot.setPadding(this.hVD, 0, this.hVD, this.hVE);
                    if (this.hVC != null && !this.hVC.isEmpty()) {
                        if (bVar.cnr().size() == 2) {
                            if (bVar.cnt().equals(this.ehG.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.hVJ.setVisibility(8);
                                cVar.hVI.setVisibility(8);
                            } else if (bVar.cnt().equals(this.ehG.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.hVJ.setVisibility(8);
                                cVar.hVI.setVisibility(0);
                                cVar.hVI.aK(this.ehG.getResources().getString(R.string.tip_assist_apply), this.hVC.cnC());
                                cVar.hVI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.hVz != null) {
                                            h.this.hVz.IE(h.this.hVC.cnD());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.cnt().equals(this.ehG.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.hVH.setVisibility(8);
                            cVar.hVJ.setVisibility(8);
                            cVar.hVI.setVisibility(8);
                        } else if (bVar.cnt().equals(this.ehG.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.hVH.setVisibility(8);
                            cVar.hVJ.setVisibility(0);
                            cVar.hVI.setVisibility(8);
                            cVar.hVJ.aK(this.ehG.getResources().getString(R.string.tip_assist_apply), this.hVC.cnC());
                            cVar.hVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.hVz != null) {
                                        h.this.hVz.IE(h.this.hVC.cnD());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.hVD, 0, this.hVD, 0);
                    cVar.hVI.setVisibility(8);
                    cVar.hVJ.setVisibility(8);
                }
                cVar.hVG.a(bVar.cnr().get(0));
                if (bVar.cnr().size() >= 2) {
                    cVar.hVH.a(bVar.cnr().get(1));
                    cVar.hVH.setVisibility(0);
                } else {
                    cVar.hVH.setVisibility(8);
                }
                this.ehG.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.dFC = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.ehG.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void av(ArrayList<i> arrayList) {
        this.hVB = arrayList;
    }

    public void a(p pVar) {
        this.hVC = pVar;
    }

    public void a(b bVar) {
        this.hVz = bVar;
    }

    /* loaded from: classes22.dex */
    public class c {
        BawuMemberInfoView hVG;
        BawuMemberInfoView hVH;
        BawuManagerApplyInfoView hVI;
        BawuManagerApplyInfoView hVJ;
        RelativeLayout mRoot;

        public c() {
        }
    }

    /* loaded from: classes22.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        View dFC;

        public a() {
        }
    }
}
