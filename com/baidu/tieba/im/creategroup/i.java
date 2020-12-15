package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class i implements o {
    HeadImageView koT;
    ImageView koU;
    TextView koV;
    private com.baidu.adp.widget.ImageView.a koW = null;
    private a koX = null;
    CreateGroupStepActivity kot;
    private int kox;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kot = null;
        this.mView = null;
        this.koT = null;
        this.koU = null;
        this.koV = null;
        this.kot = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.koU = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.koT = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.koV = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.kox = i3;
    }

    public void cUM() {
        if (this.koX != null) {
            this.koX.cancel();
        }
        this.koW = null;
        this.koX = new a();
        this.koX.execute(new Object[0]);
    }

    public ImageView cUN() {
        return this.koU;
    }

    public TextView cUO() {
        return this.koV;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUx() {
        this.koU.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUy() {
        this.kot.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kot.getLayoutMode().onModeChanged(this.mView);
        this.koT.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.getImage(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.koT.setVisibility(0);
                i.this.koW = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.koW.drawImageTo(i.this.koT);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kot.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cUA() {
        if (this.mIndex != this.kox) {
            return this.kot.getPageContext().getString(R.string.next_step);
        }
        return this.kot.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUB() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cUr() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUC() {
        return true;
    }
}
