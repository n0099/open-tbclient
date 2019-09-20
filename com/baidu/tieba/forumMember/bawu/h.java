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
    private int eam;
    private b fsb;
    private ArrayList<i> fsd = new ArrayList<>();
    private p fse;
    private int fsf;
    private TbPageContext<?> mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void xj(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.eam = 0;
        this.fsf = 0;
        this.mContext = tbPageContext;
        this.eam = l.g(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.fsf = l.g(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fsd != null) {
            return this.fsd.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rf */
    public i getItem(int i) {
        if (this.fsd == null || i >= this.fsd.size()) {
            return null;
        }
        return this.fsd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).blh();
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
                cVar2.fsi.setVisibility(0);
                cVar2.fsj.setVisibility(8);
                cVar2.fsk.setVisibility(8);
                cVar2.fsl.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.fsh = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.fsi = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.fsj = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.fsk = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.fsl = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bli() != null && bVar.bli().size() > 0) {
                if (bVar.isLast() && bVar.blj()) {
                    cVar.fsh.setPadding(this.eam, 0, this.eam, this.fsf);
                    if (this.fse != null && !this.fse.isEmpty()) {
                        if (bVar.bli().size() == 2) {
                            if (bVar.blk().equals(this.mContext.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.fsl.setVisibility(8);
                                cVar.fsk.setVisibility(8);
                            } else if (bVar.blk().equals(this.mContext.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.fsl.setVisibility(8);
                                cVar.fsk.setVisibility(0);
                                cVar.fsk.av(this.mContext.getResources().getString(R.string.tip_assist_apply), this.fse.blu());
                                cVar.fsk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.fsb != null) {
                                            h.this.fsb.xj(h.this.fse.blv());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.blk().equals(this.mContext.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.fsj.setVisibility(8);
                            cVar.fsl.setVisibility(8);
                            cVar.fsk.setVisibility(8);
                        } else if (bVar.blk().equals(this.mContext.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.fsj.setVisibility(8);
                            cVar.fsl.setVisibility(0);
                            cVar.fsk.setVisibility(8);
                            cVar.fsl.av(this.mContext.getResources().getString(R.string.tip_assist_apply), this.fse.blu());
                            cVar.fsl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.fsb != null) {
                                        h.this.fsb.xj(h.this.fse.blv());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.fsh.setPadding(this.eam, 0, this.eam, 0);
                    cVar.fsk.setVisibility(8);
                    cVar.fsl.setVisibility(8);
                }
                cVar.fsi.a(bVar.bli().get(0));
                if (bVar.bli().size() >= 2) {
                    cVar.fsj.a(bVar.bli().get(1));
                    cVar.fsj.setVisibility(0);
                } else {
                    cVar.fsj.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.brc = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void U(ArrayList<i> arrayList) {
        this.fsd = arrayList;
    }

    public void a(p pVar) {
        this.fse = pVar;
    }

    public void a(b bVar) {
        this.fsb = bVar;
    }

    /* loaded from: classes5.dex */
    public class c {
        RelativeLayout fsh;
        BawuMemberInfoView fsi;
        BawuMemberInfoView fsj;
        BawuManagerApplyInfoView fsk;
        BawuManagerApplyInfoView fsl;

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
        View brc;

        public a() {
        }
    }
}
