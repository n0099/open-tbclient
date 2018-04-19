package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> adf;
    private int bQg;
    private ArrayList<i> cTC = new ArrayList<>();
    private p cTD;
    private int cTE;

    public h(TbPageContext<?> tbPageContext) {
        this.bQg = 0;
        this.cTE = 0;
        this.adf = tbPageContext;
        this.bQg = l.e(tbPageContext.getPageActivity(), d.e.ds24);
        this.cTE = l.e(tbPageContext.getPageActivity(), d.e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cTC != null) {
            return this.cTC.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jP */
    public i getItem(int i) {
        if (this.cTC == null || i >= this.cTC.size()) {
            return null;
        }
        return this.cTC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).anY();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        if (getItemViewType(i) == 0) {
            if (view2 != null && (view2.getTag() instanceof c)) {
                cVar = (c) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.bawu_item_title_view, viewGroup, false);
                c cVar2 = new c();
                cVar2.mTextView = (TextView) view2.findViewById(d.g.text_view_title);
                cVar2.mLine = view2.findViewById(d.g.line_divider);
                view2.setTag(cVar2);
                cVar = cVar2;
            }
            cVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.adf.getLayoutMode().u(view2);
        } else if (getItemViewType(i) == 1) {
            if (view2 != null && (view2.getTag() instanceof b)) {
                b bVar2 = (b) view2.getTag();
                bVar2.cTH.setVisibility(0);
                bVar2.cTI.setVisibility(8);
                bVar2.cTJ.setVisibility(8);
                bVar2.cTK.setVisibility(8);
                bVar = bVar2;
            } else {
                view2 = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.bawu_item_member, viewGroup, false);
                b bVar3 = new b();
                bVar3.cTG = (RelativeLayout) view2.findViewById(d.g.bawu_item_member_root);
                bVar3.cTH = (BawuMemberInfoView) view2.findViewById(d.g.left_member);
                bVar3.cTI = (BawuMemberInfoView) view2.findViewById(d.g.right_member);
                bVar3.cTJ = (BawuManagerApplyInfoView) view2.findViewById(d.g.left_manager_apply);
                bVar3.cTK = (BawuManagerApplyInfoView) view2.findViewById(d.g.right_manager_apply);
                view2.setTag(bVar3);
                bVar = bVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar4 = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar4 != null && bVar4.anZ() != null && bVar4.anZ().size() > 0) {
                if (bVar4.isLast()) {
                    bVar.cTG.setPadding(this.bQg, 0, this.bQg, this.cTE);
                    if (this.cTD != null && !this.cTD.isEmpty()) {
                        if (bVar4.anZ().size() == 2) {
                            if (bVar4.aoa().equals(this.adf.getResources().getString(d.k.bawu_member_bazhu_tip))) {
                                bVar.cTK.setVisibility(8);
                                bVar.cTJ.setVisibility(0);
                                bVar.cTJ.V(this.adf.getResources().getString(d.k.tip_manager_apply), this.cTD.aol());
                                bVar.cTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view3) {
                                        ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.adf.getPageActivity()), new String[]{h.this.cTD.aoo()});
                                    }
                                });
                            } else if (bVar4.aoa().equals(this.adf.getResources().getString(d.k.bawu_member_xbazhu_tip))) {
                                bVar.cTK.setVisibility(8);
                                bVar.cTJ.setVisibility(0);
                                bVar.cTJ.V(this.adf.getResources().getString(d.k.tip_assist_apply), this.cTD.aon());
                                bVar.cTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view3) {
                                        ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.adf.getPageActivity()), new String[]{h.this.cTD.aop()});
                                    }
                                });
                            }
                        } else if (bVar4.aoa().equals(this.adf.getResources().getString(d.k.bawu_member_bazhu_tip))) {
                            bVar.cTI.setVisibility(8);
                            bVar.cTK.setVisibility(0);
                            bVar.cTJ.setVisibility(8);
                            bVar.cTK.V(this.adf.getResources().getString(d.k.tip_manager_apply), this.cTD.aol());
                            bVar.cTK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view3) {
                                    ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.adf.getPageActivity()), new String[]{h.this.cTD.aoo()});
                                }
                            });
                        } else if (bVar4.aoa().equals(this.adf.getResources().getString(d.k.bawu_member_xbazhu_tip))) {
                            bVar.cTI.setVisibility(8);
                            bVar.cTK.setVisibility(0);
                            bVar.cTJ.setVisibility(8);
                            bVar.cTK.V(this.adf.getResources().getString(d.k.tip_assist_apply), this.cTD.aon());
                            bVar.cTK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view3) {
                                    ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.adf.getPageActivity()), new String[]{h.this.cTD.aop()});
                                }
                            });
                        }
                    }
                } else {
                    bVar.cTG.setPadding(this.bQg, 0, this.bQg, 0);
                    bVar.cTJ.setVisibility(8);
                    bVar.cTK.setVisibility(8);
                }
                bVar.cTH.a(bVar4.anZ().get(0));
                if (bVar4.anZ().size() >= 2) {
                    bVar.cTI.a(bVar4.anZ().get(1));
                    bVar.cTI.setVisibility(0);
                } else {
                    bVar.cTI.setVisibility(8);
                }
                this.adf.getLayoutMode().u(view2);
            }
        } else if (getItemViewType(i) == 2) {
            if (view2 != null && (view2.getTag() instanceof a)) {
                a aVar = (a) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cJP = view2.findViewById(d.g.divider_view);
                view2.setTag(aVar2);
            }
            this.adf.getLayoutMode().u(view2);
        }
        return view2;
    }

    public void I(ArrayList<i> arrayList) {
        this.cTC = arrayList;
    }

    public void a(p pVar) {
        this.cTD = pVar;
    }

    /* loaded from: classes3.dex */
    public class b {
        RelativeLayout cTG;
        BawuMemberInfoView cTH;
        BawuMemberInfoView cTI;
        BawuManagerApplyInfoView cTJ;
        BawuManagerApplyInfoView cTK;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        View mLine;
        TextView mTextView;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        View cJP;

        public a() {
        }
    }
}
