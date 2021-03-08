package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.l;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> eWx;
    private int eXY;
    private b jdK;
    private ArrayList<i> jdM = new ArrayList<>();
    private l jdN;
    private int jdO;

    /* loaded from: classes7.dex */
    public interface b {
        void Kf(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.eXY = 0;
        this.jdO = 0;
        this.eWx = tbPageContext;
        this.eXY = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.jdO = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jdM != null) {
            return this.jdM.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yi */
    public i getItem(int i) {
        if (this.jdM == null || i >= this.jdM.size()) {
            return null;
        }
        return this.jdM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).cAP();
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
                view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.eWx.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.jdR.setVisibility(0);
                cVar2.jdS.setVisibility(8);
                cVar2.jdT.setVisibility(8);
                cVar2.jdU.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.jdQ = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.jdR = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.jdS = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.jdT = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.jdU = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.cAQ() != null && bVar.cAQ().size() > 0) {
                if (bVar.isLast() && bVar.cAR()) {
                    cVar.jdQ.setPadding(this.eXY, 0, this.eXY, this.jdO);
                    if (this.jdN != null && !this.jdN.isEmpty()) {
                        if (bVar.cAQ().size() == 2) {
                            if (bVar.cAS().equals(this.eWx.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.jdU.setVisibility(8);
                                cVar.jdT.setVisibility(8);
                            } else if (bVar.cAS().equals(this.eWx.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.jdU.setVisibility(8);
                                cVar.jdT.setVisibility(0);
                                cVar.jdT.aX(this.eWx.getResources().getString(R.string.tip_assist_apply), this.jdN.cBb());
                                cVar.jdT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.jdK != null) {
                                            h.this.jdK.Kf(h.this.jdN.cBc());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.cAS().equals(this.eWx.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.jdS.setVisibility(8);
                            cVar.jdU.setVisibility(8);
                            cVar.jdT.setVisibility(8);
                        } else if (bVar.cAS().equals(this.eWx.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.jdS.setVisibility(8);
                            cVar.jdU.setVisibility(0);
                            cVar.jdT.setVisibility(8);
                            cVar.jdU.aX(this.eWx.getResources().getString(R.string.tip_assist_apply), this.jdN.cBb());
                            cVar.jdU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.jdK != null) {
                                        h.this.jdK.Kf(h.this.jdN.cBc());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.jdQ.setPadding(this.eXY, 0, this.eXY, 0);
                    cVar.jdT.setVisibility(8);
                    cVar.jdU.setVisibility(8);
                }
                cVar.jdR.a(bVar.cAQ().get(0));
                if (bVar.cAQ().size() >= 2) {
                    cVar.jdS.a(bVar.cAQ().get(1));
                    cVar.jdS.setVisibility(0);
                } else {
                    cVar.jdS.setVisibility(8);
                }
                this.eWx.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.etk = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.eWx.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void as(ArrayList<i> arrayList) {
        this.jdM = arrayList;
    }

    public void a(l lVar) {
        this.jdN = lVar;
    }

    public void a(b bVar) {
        this.jdK = bVar;
    }

    /* loaded from: classes7.dex */
    public class c {
        RelativeLayout jdQ;
        BawuMemberInfoView jdR;
        BawuMemberInfoView jdS;
        BawuManagerApplyInfoView jdT;
        BawuManagerApplyInfoView jdU;

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
        View etk;

        public a() {
        }
    }
}
