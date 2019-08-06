package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText cub;

    public c(Context context) {
        super(context, (String) null, 29);
        this.csS = false;
        this.csR = 3;
        this.csa = new TopicDetaiInputContainer(context);
        this.cub = ((TopicDetaiInputContainer) this.csa).getInputView();
        ((TopicDetaiInputContainer) this.csa).setHint(context.getString(R.string.say_your_point));
        this.csT = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.cub;
    }
}
