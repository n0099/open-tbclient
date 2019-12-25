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
/* loaded from: classes7.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> cQU;
    private b geS;
    private ArrayList<i> geU = new ArrayList<>();
    private p geV;
    private int geW;
    private int geX;

    /* loaded from: classes7.dex */
    public interface b {
        void Au(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.geW = 0;
        this.geX = 0;
        this.cQU = tbPageContext;
        this.geW = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.geX = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.geU != null) {
            return this.geU.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sd */
    public i getItem(int i) {
        if (this.geU == null || i >= this.geU.size()) {
            return null;
        }
        return this.geU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bzH();
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
                view = LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.cQU.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.geZ.setVisibility(0);
                cVar2.gfa.setVisibility(8);
                cVar2.gfb.setVisibility(8);
                cVar2.gfc.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.geZ = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.gfa = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.gfb = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.gfc = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bzI() != null && bVar.bzI().size() > 0) {
                if (bVar.isLast() && bVar.bzJ()) {
                    cVar.mRoot.setPadding(this.geW, 0, this.geW, this.geX);
                    if (this.geV != null && !this.geV.isEmpty()) {
                        if (bVar.bzI().size() == 2) {
                            if (bVar.bzK().equals(this.cQU.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.gfc.setVisibility(8);
                                cVar.gfb.setVisibility(8);
                            } else if (bVar.bzK().equals(this.cQU.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.gfc.setVisibility(8);
                                cVar.gfb.setVisibility(0);
                                cVar.gfb.az(this.cQU.getResources().getString(R.string.tip_assist_apply), this.geV.bzT());
                                cVar.gfb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.geS != null) {
                                            h.this.geS.Au(h.this.geV.bzU());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bzK().equals(this.cQU.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.gfa.setVisibility(8);
                            cVar.gfc.setVisibility(8);
                            cVar.gfb.setVisibility(8);
                        } else if (bVar.bzK().equals(this.cQU.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.gfa.setVisibility(8);
                            cVar.gfc.setVisibility(0);
                            cVar.gfb.setVisibility(8);
                            cVar.gfc.az(this.cQU.getResources().getString(R.string.tip_assist_apply), this.geV.bzT());
                            cVar.gfc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.geS != null) {
                                        h.this.geS.Au(h.this.geV.bzU());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.geW, 0, this.geW, 0);
                    cVar.gfb.setVisibility(8);
                    cVar.gfc.setVisibility(8);
                }
                cVar.geZ.a(bVar.bzI().get(0));
                if (bVar.bzI().size() >= 2) {
                    cVar.gfa.a(bVar.bzI().get(1));
                    cVar.gfa.setVisibility(0);
                } else {
                    cVar.gfa.setVisibility(8);
                }
                this.cQU.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cuo = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.cQU.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void ak(ArrayList<i> arrayList) {
        this.geU = arrayList;
    }

    public void a(p pVar) {
        this.geV = pVar;
    }

    public void a(b bVar) {
        this.geS = bVar;
    }

    /* loaded from: classes7.dex */
    public class c {
        BawuMemberInfoView geZ;
        BawuMemberInfoView gfa;
        BawuManagerApplyInfoView gfb;
        BawuManagerApplyInfoView gfc;
        RelativeLayout mRoot;

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
        View cuo;

        public a() {
        }
    }
}
