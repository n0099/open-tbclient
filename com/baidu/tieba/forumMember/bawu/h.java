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
    private int cvU;
    private b dHE;
    private ArrayList<i> dHG = new ArrayList<>();
    private p dHH;
    private int dHI;
    private TbPageContext<?> mContext;

    /* loaded from: classes3.dex */
    public interface b {
        void oi(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.cvU = 0;
        this.dHI = 0;
        this.mContext = tbPageContext;
        this.cvU = l.h(tbPageContext.getPageActivity(), e.C0210e.ds24);
        this.dHI = l.h(tbPageContext.getPageActivity(), e.C0210e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dHG != null) {
            return this.dHG.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lX */
    public i getItem(int i) {
        if (this.dHG == null || i >= this.dHG.size()) {
            return null;
        }
        return this.dHG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).aAu();
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
                cVar2.dHL.setVisibility(0);
                cVar2.dHM.setVisibility(8);
                cVar2.dHN.setVisibility(8);
                cVar2.dHO.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.dHK = (RelativeLayout) view.findViewById(e.g.bawu_item_member_root);
                cVar3.dHL = (BawuMemberInfoView) view.findViewById(e.g.left_member);
                cVar3.dHM = (BawuMemberInfoView) view.findViewById(e.g.right_member);
                cVar3.dHN = (BawuManagerApplyInfoView) view.findViewById(e.g.left_manager_apply);
                cVar3.dHO = (BawuManagerApplyInfoView) view.findViewById(e.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.aAv() != null && bVar.aAv().size() > 0) {
                if (bVar.isLast()) {
                    cVar.dHK.setPadding(this.cvU, 0, this.cvU, this.dHI);
                    if (this.dHH != null && !this.dHH.isEmpty()) {
                        if (bVar.aAv().size() == 2) {
                            if (bVar.aAw().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                                cVar.dHO.setVisibility(8);
                                cVar.dHN.setVisibility(0);
                                cVar.dHN.ac(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dHH.aAH());
                                cVar.dHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dHE != null) {
                                            h.this.dHE.oi(h.this.dHH.aAK());
                                        }
                                    }
                                });
                            } else if (bVar.aAw().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                                cVar.dHO.setVisibility(8);
                                cVar.dHN.setVisibility(0);
                                cVar.dHN.ac(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dHH.aAJ());
                                cVar.dHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dHE != null) {
                                            h.this.dHE.oi(h.this.dHH.aAL());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.aAw().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                            cVar.dHM.setVisibility(8);
                            cVar.dHO.setVisibility(0);
                            cVar.dHN.setVisibility(8);
                            cVar.dHO.ac(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dHH.aAH());
                            cVar.dHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dHE != null) {
                                        h.this.dHE.oi(h.this.dHH.aAK());
                                    }
                                }
                            });
                        } else if (bVar.aAw().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                            cVar.dHM.setVisibility(8);
                            cVar.dHO.setVisibility(0);
                            cVar.dHN.setVisibility(8);
                            cVar.dHO.ac(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dHH.aAJ());
                            cVar.dHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dHE != null) {
                                        h.this.dHE.oi(h.this.dHH.aAL());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.dHK.setPadding(this.cvU, 0, this.cvU, 0);
                    cVar.dHN.setVisibility(8);
                    cVar.dHO.setVisibility(8);
                }
                cVar.dHL.a(bVar.aAv().get(0));
                if (bVar.aAv().size() >= 2) {
                    cVar.dHM.a(bVar.aAv().get(1));
                    cVar.dHM.setVisibility(0);
                } else {
                    cVar.dHM.setVisibility(8);
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
        this.dHG = arrayList;
    }

    public void a(p pVar) {
        this.dHH = pVar;
    }

    public void a(b bVar) {
        this.dHE = bVar;
    }

    /* loaded from: classes3.dex */
    public class c {
        RelativeLayout dHK;
        BawuMemberInfoView dHL;
        BawuMemberInfoView dHM;
        BawuManagerApplyInfoView dHN;
        BawuManagerApplyInfoView dHO;

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
