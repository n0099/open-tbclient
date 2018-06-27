package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private int cbg;
    private b dfH;
    private ArrayList<i> dfJ = new ArrayList<>();
    private p dfK;
    private int dfL;
    private TbPageContext<?> mContext;

    /* loaded from: classes3.dex */
    public interface b {
        void mj(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.cbg = 0;
        this.dfL = 0;
        this.mContext = tbPageContext;
        this.cbg = l.e(tbPageContext.getPageActivity(), d.e.ds24);
        this.dfL = l.e(tbPageContext.getPageActivity(), d.e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dfJ != null) {
            return this.dfJ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jU */
    public i getItem(int i) {
        if (this.dfJ == null || i >= this.dfJ.size()) {
            return null;
        }
        return this.dfJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).asn();
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
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(d.g.text_view_title);
                dVar2.mLine = view.findViewById(d.g.line_divider);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.dfO.setVisibility(0);
                cVar2.dfP.setVisibility(8);
                cVar2.dfQ.setVisibility(8);
                cVar2.dfR.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.dfN = (RelativeLayout) view.findViewById(d.g.bawu_item_member_root);
                cVar3.dfO = (BawuMemberInfoView) view.findViewById(d.g.left_member);
                cVar3.dfP = (BawuMemberInfoView) view.findViewById(d.g.right_member);
                cVar3.dfQ = (BawuManagerApplyInfoView) view.findViewById(d.g.left_manager_apply);
                cVar3.dfR = (BawuManagerApplyInfoView) view.findViewById(d.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.aso() != null && bVar.aso().size() > 0) {
                if (bVar.isLast()) {
                    cVar.dfN.setPadding(this.cbg, 0, this.cbg, this.dfL);
                    if (this.dfK != null && !this.dfK.isEmpty()) {
                        if (bVar.aso().size() == 2) {
                            if (bVar.asp().equals(this.mContext.getResources().getString(d.k.bawu_member_bazhu_tip))) {
                                cVar.dfR.setVisibility(8);
                                cVar.dfQ.setVisibility(0);
                                cVar.dfQ.V(this.mContext.getResources().getString(d.k.tip_manager_apply), this.dfK.asA());
                                cVar.dfQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dfH != null) {
                                            h.this.dfH.mj(h.this.dfK.asD());
                                        }
                                    }
                                });
                            } else if (bVar.asp().equals(this.mContext.getResources().getString(d.k.bawu_member_xbazhu_tip))) {
                                cVar.dfR.setVisibility(8);
                                cVar.dfQ.setVisibility(0);
                                cVar.dfQ.V(this.mContext.getResources().getString(d.k.tip_assist_apply), this.dfK.asC());
                                cVar.dfQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dfH != null) {
                                            h.this.dfH.mj(h.this.dfK.asE());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.asp().equals(this.mContext.getResources().getString(d.k.bawu_member_bazhu_tip))) {
                            cVar.dfP.setVisibility(8);
                            cVar.dfR.setVisibility(0);
                            cVar.dfQ.setVisibility(8);
                            cVar.dfR.V(this.mContext.getResources().getString(d.k.tip_manager_apply), this.dfK.asA());
                            cVar.dfR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dfH != null) {
                                        h.this.dfH.mj(h.this.dfK.asD());
                                    }
                                }
                            });
                        } else if (bVar.asp().equals(this.mContext.getResources().getString(d.k.bawu_member_xbazhu_tip))) {
                            cVar.dfP.setVisibility(8);
                            cVar.dfR.setVisibility(0);
                            cVar.dfQ.setVisibility(8);
                            cVar.dfR.V(this.mContext.getResources().getString(d.k.tip_assist_apply), this.dfK.asC());
                            cVar.dfR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dfH != null) {
                                        h.this.dfH.mj(h.this.dfK.asE());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.dfN.setPadding(this.cbg, 0, this.cbg, 0);
                    cVar.dfQ.setVisibility(8);
                    cVar.dfR.setVisibility(8);
                }
                cVar.dfO.a(bVar.aso().get(0));
                if (bVar.aso().size() >= 2) {
                    cVar.dfP.a(bVar.aso().get(1));
                    cVar.dfP.setVisibility(0);
                } else {
                    cVar.dfP.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cSc = view.findViewById(d.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void N(ArrayList<i> arrayList) {
        this.dfJ = arrayList;
    }

    public void a(p pVar) {
        this.dfK = pVar;
    }

    public void a(b bVar) {
        this.dfH = bVar;
    }

    /* loaded from: classes3.dex */
    public class c {
        RelativeLayout dfN;
        BawuMemberInfoView dfO;
        BawuMemberInfoView dfP;
        BawuManagerApplyInfoView dfQ;
        BawuManagerApplyInfoView dfR;

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
        View cSc;

        public a() {
        }
    }
}
