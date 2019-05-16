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
/* loaded from: classes5.dex */
public class h extends BaseAdapter {
    private int dUC;
    private b fkP;
    private ArrayList<i> fkR = new ArrayList<>();
    private p fkS;
    private int fkT;
    private TbPageContext<?> mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void wf(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.dUC = 0;
        this.fkT = 0;
        this.mContext = tbPageContext;
        this.dUC = l.g(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.fkT = l.g(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fkR != null) {
            return this.fkR.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qI */
    public i getItem(int i) {
        if (this.fkR == null || i >= this.fkR.size()) {
            return null;
        }
        return this.fkR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bik();
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
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.fkW.setVisibility(0);
                cVar2.fkX.setVisibility(8);
                cVar2.fkY.setVisibility(8);
                cVar2.fkZ.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.fkV = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.fkW = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.fkX = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.fkY = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.fkZ = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bil() != null && bVar.bil().size() > 0) {
                if (bVar.isLast() && bVar.bim()) {
                    cVar.fkV.setPadding(this.dUC, 0, this.dUC, this.fkT);
                    if (this.fkS != null && !this.fkS.isEmpty()) {
                        if (bVar.bil().size() == 2) {
                            if (bVar.bin().equals(this.mContext.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.fkZ.setVisibility(8);
                                cVar.fkY.setVisibility(8);
                            } else if (bVar.bin().equals(this.mContext.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.fkZ.setVisibility(8);
                                cVar.fkY.setVisibility(0);
                                cVar.fkY.as(this.mContext.getResources().getString(R.string.tip_assist_apply), this.fkS.bix());
                                cVar.fkY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.fkP != null) {
                                            h.this.fkP.wf(h.this.fkS.biy());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bin().equals(this.mContext.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.fkX.setVisibility(8);
                            cVar.fkZ.setVisibility(8);
                            cVar.fkY.setVisibility(8);
                        } else if (bVar.bin().equals(this.mContext.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.fkX.setVisibility(8);
                            cVar.fkZ.setVisibility(0);
                            cVar.fkY.setVisibility(8);
                            cVar.fkZ.as(this.mContext.getResources().getString(R.string.tip_assist_apply), this.fkS.bix());
                            cVar.fkZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.fkP != null) {
                                        h.this.fkP.wf(h.this.fkS.biy());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.fkV.setPadding(this.dUC, 0, this.dUC, 0);
                    cVar.fkY.setVisibility(8);
                    cVar.fkZ.setVisibility(8);
                }
                cVar.fkW.a(bVar.bil().get(0));
                if (bVar.bil().size() >= 2) {
                    cVar.fkX.a(bVar.bil().get(1));
                    cVar.fkX.setVisibility(0);
                } else {
                    cVar.fkX.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.bpR = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void U(ArrayList<i> arrayList) {
        this.fkR = arrayList;
    }

    public void a(p pVar) {
        this.fkS = pVar;
    }

    public void a(b bVar) {
        this.fkP = bVar;
    }

    /* loaded from: classes5.dex */
    public class c {
        RelativeLayout fkV;
        BawuMemberInfoView fkW;
        BawuMemberInfoView fkX;
        BawuManagerApplyInfoView fkY;
        BawuManagerApplyInfoView fkZ;

        public c() {
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes5.dex */
    public class a {
        View bpR;

        public a() {
        }
    }
}
