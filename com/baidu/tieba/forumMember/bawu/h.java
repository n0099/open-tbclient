package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private int cvj;
    private b dGV;
    private ArrayList<i> dGX = new ArrayList<>();
    private p dGY;
    private int dGZ;
    private TbPageContext<?> mContext;

    /* loaded from: classes3.dex */
    public interface b {
        void nR(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.cvj = 0;
        this.dGZ = 0;
        this.mContext = tbPageContext;
        this.cvj = l.h(tbPageContext.getPageActivity(), e.C0210e.ds24);
        this.dGZ = l.h(tbPageContext.getPageActivity(), e.C0210e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dGX != null) {
            return this.dGX.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lW */
    public i getItem(int i) {
        if (this.dGX == null || i >= this.dGX.size()) {
            return null;
        }
        return this.dGX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).azX();
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
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(e.g.text_view_title);
                dVar2.mLine = view.findViewById(e.g.line_divider);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.dHc.setVisibility(0);
                cVar2.dHd.setVisibility(8);
                cVar2.dHe.setVisibility(8);
                cVar2.dHf.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.dHb = (RelativeLayout) view.findViewById(e.g.bawu_item_member_root);
                cVar3.dHc = (BawuMemberInfoView) view.findViewById(e.g.left_member);
                cVar3.dHd = (BawuMemberInfoView) view.findViewById(e.g.right_member);
                cVar3.dHe = (BawuManagerApplyInfoView) view.findViewById(e.g.left_manager_apply);
                cVar3.dHf = (BawuManagerApplyInfoView) view.findViewById(e.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.azY() != null && bVar.azY().size() > 0) {
                if (bVar.isLast()) {
                    cVar.dHb.setPadding(this.cvj, 0, this.cvj, this.dGZ);
                    if (this.dGY != null && !this.dGY.isEmpty()) {
                        if (bVar.azY().size() == 2) {
                            if (bVar.azZ().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                                cVar.dHf.setVisibility(8);
                                cVar.dHe.setVisibility(0);
                                cVar.dHe.ac(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dGY.aAk());
                                cVar.dHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dGV != null) {
                                            h.this.dGV.nR(h.this.dGY.aAn());
                                        }
                                    }
                                });
                            } else if (bVar.azZ().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                                cVar.dHf.setVisibility(8);
                                cVar.dHe.setVisibility(0);
                                cVar.dHe.ac(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dGY.aAm());
                                cVar.dHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dGV != null) {
                                            h.this.dGV.nR(h.this.dGY.aAo());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.azZ().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                            cVar.dHd.setVisibility(8);
                            cVar.dHf.setVisibility(0);
                            cVar.dHe.setVisibility(8);
                            cVar.dHf.ac(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dGY.aAk());
                            cVar.dHf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dGV != null) {
                                        h.this.dGV.nR(h.this.dGY.aAn());
                                    }
                                }
                            });
                        } else if (bVar.azZ().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                            cVar.dHd.setVisibility(8);
                            cVar.dHf.setVisibility(0);
                            cVar.dHe.setVisibility(8);
                            cVar.dHf.ac(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dGY.aAm());
                            cVar.dHf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dGV != null) {
                                        h.this.dGV.nR(h.this.dGY.aAo());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.dHb.setPadding(this.cvj, 0, this.cvj, 0);
                    cVar.dHe.setVisibility(8);
                    cVar.dHf.setVisibility(8);
                }
                cVar.dHc.a(bVar.azY().get(0));
                if (bVar.azY().size() >= 2) {
                    cVar.dHd.a(bVar.azY().get(1));
                    cVar.dHd.setVisibility(0);
                } else {
                    cVar.dHd.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.mDividerView = view.findViewById(e.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void N(ArrayList<i> arrayList) {
        this.dGX = arrayList;
    }

    public void a(p pVar) {
        this.dGY = pVar;
    }

    public void a(b bVar) {
        this.dGV = bVar;
    }

    /* loaded from: classes3.dex */
    public class c {
        RelativeLayout dHb;
        BawuMemberInfoView dHc;
        BawuMemberInfoView dHd;
        BawuManagerApplyInfoView dHe;
        BawuManagerApplyInfoView dHf;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        View mLine;
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        View mDividerView;

        public a() {
        }
    }
}
