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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> aiP = new ArrayList<>();
    private c jYI;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes25.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.jYI = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.aiP.clear();
            this.aiP.addAll(arrayList);
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
        if (this.aiP != null && this.aiP.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.aiP.get(i);
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
        if (this.aiP == null) {
            return 0;
        }
        return this.aiP.size();
    }

    /* loaded from: classes25.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private BarImageView jYK;
        private View jYL;
        private a jYM;
        private TextView jmU;

        b(View view) {
            super(view);
            this.jYK = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.jmU = (TextView) view.findViewById(R.id.official_bar_name);
            this.jYL = view.findViewById(R.id.official_bar_feed_red_dot);
            this.jYK.setShowOval(true);
            this.jYK.setPlaceHolder(2);
            this.jYK.setShowOuterBorder(false);
            this.jYK.setShowInnerBorder(true);
            this.jYK.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.jYM = (a) aVar;
            ap.setViewTextColor(this.jmU, R.color.CAM_X0105);
            ap.setBackgroundResource(this.jYL, R.drawable.icon_official_bar_red_dot);
            this.jYK.setStrokeColorResId(R.color.CAM_X0401);
            this.jYK.startLoad(this.jYM.cOJ(), 10, false);
            if (au.getChineseAndEnglishLength(this.jYM.cIF()) <= 10) {
                this.jmU.setText(this.jYM.cIF());
            } else {
                this.jmU.setText(au.cutChineseAndEnglishWithSuffix(this.jYM.cIF(), 8, StringHelper.STRING_MORE));
            }
            this.jYK.setOnClickListener(this);
            if (this.jYM.getUnReadCount() > 0 && (this.jYM.cOK() <= 0 || System.currentTimeMillis() - this.jYM.cOK() < 864000000)) {
                this.jYL.setVisibility(0);
            } else {
                this.jYL.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.jYL.setVisibility(8);
            if (d.this.jYI != null) {
                d.this.jYI.a(view, this.jYM, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long cPT;
        private long groupId;
        private String jYJ;
        private String jxU;
        private int unReadCount;
        private int userType;

        String cOJ() {
            return this.jYJ;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cIF() {
            return this.jxU;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void LF(String str) {
            this.jYJ = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void LG(String str) {
            this.jxU = str;
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

        public long cOK() {
            return this.cPT;
        }

        public void gh(long j) {
            this.cPT = j;
        }
    }
}
