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
    private TbPageContext<?> eGu;
    private int eHL;
    private b iDI;
    private ArrayList<i> iDK = new ArrayList<>();
    private p iDL;
    private int iDM;

    /* loaded from: classes22.dex */
    public interface b {
        void JI(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.eHL = 0;
        this.iDM = 0;
        this.eGu = tbPageContext;
        this.eHL = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.iDM = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iDK != null) {
            return this.iDK.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yL */
    public i getItem(int i) {
        if (this.iDK == null || i >= this.iDK.size()) {
            return null;
        }
        return this.iDK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).cvZ();
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
                view = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.eGu.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.iDO.setVisibility(0);
                cVar2.iDP.setVisibility(8);
                cVar2.iDQ.setVisibility(8);
                cVar2.iDR.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.iDO = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.iDP = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.iDQ = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.iDR = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.cwa() != null && bVar.cwa().size() > 0) {
                if (bVar.isLast() && bVar.cwb()) {
                    cVar.mRoot.setPadding(this.eHL, 0, this.eHL, this.iDM);
                    if (this.iDL != null && !this.iDL.isEmpty()) {
                        if (bVar.cwa().size() == 2) {
                            if (bVar.cwc().equals(this.eGu.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.iDR.setVisibility(8);
                                cVar.iDQ.setVisibility(8);
                            } else if (bVar.cwc().equals(this.eGu.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.iDR.setVisibility(8);
                                cVar.iDQ.setVisibility(0);
                                cVar.iDQ.aN(this.eGu.getResources().getString(R.string.tip_assist_apply), this.iDL.cwl());
                                cVar.iDQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.iDI != null) {
                                            h.this.iDI.JI(h.this.iDL.cwm());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.cwc().equals(this.eGu.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.iDP.setVisibility(8);
                            cVar.iDR.setVisibility(8);
                            cVar.iDQ.setVisibility(8);
                        } else if (bVar.cwc().equals(this.eGu.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.iDP.setVisibility(8);
                            cVar.iDR.setVisibility(0);
                            cVar.iDQ.setVisibility(8);
                            cVar.iDR.aN(this.eGu.getResources().getString(R.string.tip_assist_apply), this.iDL.cwl());
                            cVar.iDR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.iDI != null) {
                                        h.this.iDI.JI(h.this.iDL.cwm());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.eHL, 0, this.eHL, 0);
                    cVar.iDQ.setVisibility(8);
                    cVar.iDR.setVisibility(8);
                }
                cVar.iDO.a(bVar.cwa().get(0));
                if (bVar.cwa().size() >= 2) {
                    cVar.iDP.a(bVar.cwa().get(1));
                    cVar.iDP.setVisibility(0);
                } else {
                    cVar.iDP.setVisibility(8);
                }
                this.eGu.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.eej = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.eGu.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void ax(ArrayList<i> arrayList) {
        this.iDK = arrayList;
    }

    public void a(p pVar) {
        this.iDL = pVar;
    }

    public void a(b bVar) {
        this.iDI = bVar;
    }

    /* loaded from: classes22.dex */
    public class c {
        BawuMemberInfoView iDO;
        BawuMemberInfoView iDP;
        BawuManagerApplyInfoView iDQ;
        BawuManagerApplyInfoView iDR;
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
        View eej;

        public a() {
        }
    }
}
