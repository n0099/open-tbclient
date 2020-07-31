package com.baidu.tieba.im.chat.officialBar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> agL = new ArrayList<>();
    private c iSU;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes20.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.iSU = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.agL.clear();
            this.agL.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.agL != null && this.agL.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.agL.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.agL == null) {
            return 0;
        }
        return this.agL.size();
    }

    /* loaded from: classes20.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private BarImageView iSX;
        private View iSY;
        private a iSZ;
        private TextView ijr;

        b(View view) {
            super(view);
            this.iSX = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.ijr = (TextView) view.findViewById(R.id.official_bar_name);
            this.iSY = view.findViewById(R.id.official_bar_feed_red_dot);
            this.iSX.setShowOval(true);
            this.iSX.setPlaceHolder(2);
            this.iSX.setShowOuterBorder(false);
            this.iSX.setShowInnerBorder(true);
            this.iSX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.iSZ = (a) aVar;
            ao.setViewTextColor(this.ijr, R.color.cp_cont_b);
            ao.setBackgroundResource(this.iSY, R.drawable.icon_official_bar_red_dot);
            this.iSX.setStrokeColorResId(R.color.cp_border_a);
            this.iSX.startLoad(this.iSZ.crm(), 10, false);
            if (as.getChineseAndEnglishLength(this.iSZ.crn()) <= 10) {
                this.ijr.setText(this.iSZ.crn());
            } else {
                this.ijr.setText(as.cutChineseAndEnglishWithSuffix(this.iSZ.crn(), 8, StringHelper.STRING_MORE));
            }
            this.iSX.setOnClickListener(this);
            if (this.iSZ.getUnReadCount() > 0 && (this.iSZ.cro() <= 0 || System.currentTimeMillis() - this.iSZ.cro() < 864000000)) {
                this.iSY.setVisibility(0);
            } else {
                this.iSY.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.iSY.setVisibility(8);
            if (d.this.iSU != null) {
                d.this.iSU.a(view, this.iSZ, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long ciw;
        private long groupId;
        private String iSV;
        private String iSW;
        private int unReadCount;
        private int userType;

        String crm() {
            return this.iSV;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String crn() {
            return this.iSW;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Hf(String str) {
            this.iSV = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Hg(String str) {
            this.iSW = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cro() {
            return this.ciw;
        }

        public void eP(long j) {
            this.ciw = j;
        }
    }
}
