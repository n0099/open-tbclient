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
    private int dUD;
    private b fkQ;
    private ArrayList<i> fkS = new ArrayList<>();
    private p fkT;
    private int fkU;
    private TbPageContext<?> mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void wf(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.dUD = 0;
        this.fkU = 0;
        this.mContext = tbPageContext;
        this.dUD = l.g(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.fkU = l.g(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fkS != null) {
            return this.fkS.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qI */
    public i getItem(int i) {
        if (this.fkS == null || i >= this.fkS.size()) {
            return null;
        }
        return this.fkS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bin();
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
                cVar2.fkX.setVisibility(0);
                cVar2.fkY.setVisibility(8);
                cVar2.fkZ.setVisibility(8);
                cVar2.fla.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.fkW = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.fkX = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.fkY = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.fkZ = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.fla = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bio() != null && bVar.bio().size() > 0) {
                if (bVar.isLast() && bVar.bip()) {
                    cVar.fkW.setPadding(this.dUD, 0, this.dUD, this.fkU);
                    if (this.fkT != null && !this.fkT.isEmpty()) {
                        if (bVar.bio().size() == 2) {
                            if (bVar.biq().equals(this.mContext.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.fla.setVisibility(8);
                                cVar.fkZ.setVisibility(8);
                            } else if (bVar.biq().equals(this.mContext.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.fla.setVisibility(8);
                                cVar.fkZ.setVisibility(0);
                                cVar.fkZ.as(this.mContext.getResources().getString(R.string.tip_assist_apply), this.fkT.biA());
                                cVar.fkZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.fkQ != null) {
                                            h.this.fkQ.wf(h.this.fkT.biB());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.biq().equals(this.mContext.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.fkY.setVisibility(8);
                            cVar.fla.setVisibility(8);
                            cVar.fkZ.setVisibility(8);
                        } else if (bVar.biq().equals(this.mContext.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.fkY.setVisibility(8);
                            cVar.fla.setVisibility(0);
                            cVar.fkZ.setVisibility(8);
                            cVar.fla.as(this.mContext.getResources().getString(R.string.tip_assist_apply), this.fkT.biA());
                            cVar.fla.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.fkQ != null) {
                                        h.this.fkQ.wf(h.this.fkT.biB());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.fkW.setPadding(this.dUD, 0, this.dUD, 0);
                    cVar.fkZ.setVisibility(8);
                    cVar.fla.setVisibility(8);
                }
                cVar.fkX.a(bVar.bio().get(0));
                if (bVar.bio().size() >= 2) {
                    cVar.fkY.a(bVar.bio().get(1));
                    cVar.fkY.setVisibility(0);
                } else {
                    cVar.fkY.setVisibility(8);
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
        this.fkS = arrayList;
    }

    public void a(p pVar) {
        this.fkT = pVar;
    }

    public void a(b bVar) {
        this.fkQ = bVar;
    }

    /* loaded from: classes5.dex */
    public class c {
        RelativeLayout fkW;
        BawuMemberInfoView fkX;
        BawuMemberInfoView fkY;
        BawuManagerApplyInfoView fkZ;
        BawuManagerApplyInfoView fla;

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
