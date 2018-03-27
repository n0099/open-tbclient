package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> aRI;
    private int czZ;
    private ArrayList<i> dAQ = new ArrayList<>();
    private p dAR;
    private int dAS;

    public h(TbPageContext<?> tbPageContext) {
        this.czZ = 0;
        this.dAS = 0;
        this.aRI = tbPageContext;
        this.czZ = l.t(tbPageContext.getPageActivity(), d.e.ds24);
        this.dAS = l.t(tbPageContext.getPageActivity(), d.e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dAQ != null) {
            return this.dAQ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mD */
    public i getItem(int i) {
        if (this.dAQ == null || i >= this.dAQ.size()) {
            return null;
        }
        return this.dAQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).atJ();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        if (getItemViewType(i) == 0) {
            if (view != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.bawu_item_title_view, viewGroup, false);
                c cVar2 = new c();
                cVar2.ry = (TextView) view.findViewById(d.g.text_view_title);
                cVar2.mLine = view.findViewById(d.g.line_divider);
                view.setTag(cVar2);
                cVar = cVar2;
            }
            cVar.ry.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.aRI.getLayoutMode().aM(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof b)) {
                b bVar2 = (b) view.getTag();
                bVar2.dAV.setVisibility(0);
                bVar2.dAW.setVisibility(8);
                bVar2.dAX.setVisibility(8);
                bVar2.dAY.setVisibility(8);
                bVar = bVar2;
            } else {
                view = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.bawu_item_member, viewGroup, false);
                b bVar3 = new b();
                bVar3.dAU = (RelativeLayout) view.findViewById(d.g.bawu_item_member_root);
                bVar3.dAV = (BawuMemberInfoView) view.findViewById(d.g.left_member);
                bVar3.dAW = (BawuMemberInfoView) view.findViewById(d.g.right_member);
                bVar3.dAX = (BawuManagerApplyInfoView) view.findViewById(d.g.left_manager_apply);
                bVar3.dAY = (BawuManagerApplyInfoView) view.findViewById(d.g.right_manager_apply);
                view.setTag(bVar3);
                bVar = bVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar4 = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar4 != null && bVar4.atK() != null && bVar4.atK().size() > 0) {
                if (bVar4.isLast()) {
                    bVar.dAU.setPadding(this.czZ, 0, this.czZ, this.dAS);
                    if (this.dAR != null && !this.dAR.isEmpty()) {
                        if (bVar4.atK().size() == 2) {
                            if (bVar4.atL().equals(this.aRI.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                                bVar.dAY.setVisibility(8);
                                bVar.dAX.setVisibility(0);
                                bVar.dAX.V(this.aRI.getResources().getString(d.j.tip_manager_apply), this.dAR.atW());
                                bVar.dAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRI.getPageActivity()), new String[]{h.this.dAR.atZ()});
                                    }
                                });
                            } else if (bVar4.atL().equals(this.aRI.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                                bVar.dAY.setVisibility(8);
                                bVar.dAX.setVisibility(0);
                                bVar.dAX.V(this.aRI.getResources().getString(d.j.tip_assist_apply), this.dAR.atY());
                                bVar.dAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRI.getPageActivity()), new String[]{h.this.dAR.aua()});
                                    }
                                });
                            }
                        } else if (bVar4.atL().equals(this.aRI.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                            bVar.dAW.setVisibility(8);
                            bVar.dAY.setVisibility(0);
                            bVar.dAX.setVisibility(8);
                            bVar.dAY.V(this.aRI.getResources().getString(d.j.tip_manager_apply), this.dAR.atW());
                            bVar.dAY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRI.getPageActivity()), new String[]{h.this.dAR.atZ()});
                                }
                            });
                        } else if (bVar4.atL().equals(this.aRI.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                            bVar.dAW.setVisibility(8);
                            bVar.dAY.setVisibility(0);
                            bVar.dAX.setVisibility(8);
                            bVar.dAY.V(this.aRI.getResources().getString(d.j.tip_assist_apply), this.dAR.atY());
                            bVar.dAY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRI.getPageActivity()), new String[]{h.this.dAR.aua()});
                                }
                            });
                        }
                    }
                } else {
                    bVar.dAU.setPadding(this.czZ, 0, this.czZ, 0);
                    bVar.dAX.setVisibility(8);
                    bVar.dAY.setVisibility(8);
                }
                bVar.dAV.a(bVar4.atK().get(0));
                if (bVar4.atK().size() >= 2) {
                    bVar.dAW.a(bVar4.atK().get(1));
                    bVar.dAW.setVisibility(0);
                } else {
                    bVar.dAW.setVisibility(8);
                }
                this.aRI.getLayoutMode().aM(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.drj = view.findViewById(d.g.divider_view);
                view.setTag(aVar2);
            }
            this.aRI.getLayoutMode().aM(view);
        }
        return view;
    }

    public void I(ArrayList<i> arrayList) {
        this.dAQ = arrayList;
    }

    public void a(p pVar) {
        this.dAR = pVar;
    }

    /* loaded from: classes3.dex */
    public class b {
        RelativeLayout dAU;
        BawuMemberInfoView dAV;
        BawuMemberInfoView dAW;
        BawuManagerApplyInfoView dAX;
        BawuManagerApplyInfoView dAY;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        View mLine;
        TextView ry;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        View drj;

        public a() {
        }
    }
}
