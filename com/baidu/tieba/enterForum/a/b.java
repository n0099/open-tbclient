package com.baidu.tieba.enterForum.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> clk = new ArrayList<>();
    private InterfaceC0600b gNT;
    private boolean gNU;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0600b {
        void a(View view, k kVar);

        void bM(View view);
    }

    public b(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.clk.clear();
            this.clk.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        return i == 2 ? new a(inflate) : new c(inflate);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.clk != null && this.clk.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.clk.get(i);
            if ((viewHolder instanceof a) && (aVar instanceof com.baidu.tieba.enterForum.data.a)) {
                ((a) viewHolder).a((com.baidu.tieba.enterForum.data.a) aVar);
            } else if ((viewHolder instanceof c) && (aVar instanceof k)) {
                ((c) viewHolder).a((k) aVar);
                an anVar = new an("c13642");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.s("fid", ((k) aVar).getForumId());
                if (this.mFrom == 0) {
                    anVar.ag("obj_locate", 1);
                    anVar.ag("obj_type", this.gNU ? 3 : 1);
                } else if (this.mFrom == 1) {
                    anVar.ag("obj_locate", 2);
                    anVar.dh("resource_id", this.mTabName);
                }
                TiebaStatic.log(anVar);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.clk.get(i) instanceof k) {
            return 1;
        }
        if (this.clk.get(i) instanceof com.baidu.tieba.enterForum.data.a) {
            return 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.clk == null) {
            return 0;
        }
        return this.clk.size();
    }

    public void a(InterfaceC0600b interfaceC0600b) {
        this.gNT = interfaceC0600b;
    }

    /* loaded from: classes9.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView aJn;
        private String attention;
        private TextView dVS;
        private BarImageView gNV;
        private ImageView gNW;
        private k gOa;
        private View mRootView;

        public c(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.gNV = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.gNW = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.dVS = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aJn = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.gNT != null) {
                        b.this.gNT.a(view2, c.this.gOa);
                    }
                }
            });
        }

        public void a(k kVar) {
            if (kVar != null) {
                this.gOa = kVar;
                this.gNV.setShowOval(true);
                this.gNV.setShowOuterBorder(false);
                this.gNV.setShowInnerBorder(true);
                this.gNV.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.gNV.setStrokeColorResId(R.color.cp_border_a);
                this.gNW.setVisibility(8);
                this.gNV.setVisibility(0);
                this.gNV.startLoad(kVar.getAvatar(), 10, false);
                if (aq.getChineseAndEnglishLength(kVar.getForumName()) <= 10) {
                    this.dVS.setText(kVar.getForumName());
                } else {
                    this.dVS.setText(aq.cutChineseAndEnglishWithSuffix(kVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.aJn.setText(this.attention + " " + aq.cn(kVar.bOo()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            am.setViewTextColor(this.dVS, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.aJn, (int) R.color.cp_cont_d);
        }
    }

    /* loaded from: classes9.dex */
    class a extends RecyclerView.ViewHolder {
        private TextView aJn;
        private String attention;
        private TextView dVS;
        private BarImageView gNV;
        private ImageView gNW;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.gNV = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.gNW = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.dVS = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aJn = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.gNT != null) {
                        b.this.gNT.bM(view2);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.enterForum.data.a aVar) {
            if (aVar != null) {
                this.gNW.setVisibility(0);
                this.gNV.setVisibility(8);
                SvgManager.aUV().a(this.gNW, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.dVS.setText(R.string.forum_square_title);
                this.aJn.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            am.setViewTextColor(this.dVS, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.aJn, (int) R.color.cp_cont_d);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.gNU = z;
    }
}
